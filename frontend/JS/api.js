// ===============================
// ADD STUDENT (Only runs if form exists)
// ===============================

const form = document.getElementById("studentForm");

if (form) {
    form.addEventListener("submit", function(e) {
        e.preventDefault();

        const student = {
            id: parseInt(document.getElementById("id").value),
            name: document.getElementById("name").value,
            age: parseInt(document.getElementById("age").value),
            mail: document.getElementById("mail").value
        };

        fetch("http://localhost:8080/student/add", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(student)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error("Failed to add student");
            }
            return response.json();
        })
        .then(data => {
            document.getElementById("message").innerText =
                "✅ Student Added Successfully";
            form.reset();
        })
        .catch(error => {
            document.getElementById("message").innerText =
                "❌ Error: " + error.message;
        });
    });
}


// ===============================
// VIEW ALL STUDENTS
// ===============================

function getStudents() {

    const table = document.getElementById("studentTable");

    if (!table) return;

    fetch("http://localhost:8080/student/getAllStudent")
        .then(response => response.json())
        .then(data => {
            console.log("DATA RECEIVED:", data);

            table.innerHTML = "";

            data.forEach(student => {
                table.innerHTML += `
<tr id="row-${student.id}">
<td>${student.id}</td>

<td class="editable">${student.name}</td>
<td class="editable">${student.age}</td>
<td class="editable">${student.mail}</td>

<td>
<button class="edit-btn" onclick="editRow(${student.id})">Edit</button>
<button class="save-btn" onclick="saveRow(${student.id})" style="display:none;">Save</button>
<button class="cancel-btn" onclick="cancelEdit(${student.id})" style="display:none;">Cancel</button>
<button class="delete-btn" onclick="deleteStudent(${student.id})">Delete</button>
</td>
</tr>
`;
            });
        })
        .catch(error => console.error("ERROR:", error));
}


// ===============================
// DELETE STUDENT
// ===============================

function deleteStudent(id) {
    fetch(`http://localhost:8080/student/delete/${id}`, {
        method: "DELETE"
    })
    .then(() => {
        alert("Deleted Successfully");
        getStudents();
    })
    .catch(error => console.error("ERROR:", error));
}


// ===============================
// INLINE EDIT LOGIC (NEW ADDED)
// ===============================

let originalData = {};

/* EDIT MODE */
function editRow(id){
    const row = document.getElementById(`row-${id}`);
    const cells = row.querySelectorAll(".editable");

    originalData[id] = [];

    cells.forEach((cell, index) => {
        originalData[id][index] = cell.innerText;
        cell.innerHTML = `<input value="${cell.innerText}" />`;
    });

    toggleButtons(row, true);
}

/* SAVE */
function saveRow(id){
    const row = document.getElementById(`row-${id}`);
    const inputs = row.querySelectorAll("input");

    const updatedData = {
        name: inputs[0].value,
        age: inputs[1].value,
        mail: inputs[2].value
    };

    row.style.opacity = "0.5";

    fetch(`http://localhost:8080/student/UpdateStudent/${id}`, {
        method: "PATCH",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(updatedData)
    })
    .then(res => res.json())
    .then(() => {

        const cells = row.querySelectorAll(".editable");

        cells[0].innerText = updatedData.name;
        cells[1].innerText = updatedData.age;
        cells[2].innerText = updatedData.mail;

        row.style.opacity = "1";

        // success highlight
        row.style.background = "rgba(72, 187, 120, 0.3)";
        setTimeout(() => row.style.background = "", 1500);

        toggleButtons(row, false);
    })
    .catch(() => {
        alert("Update failed");
        row.style.opacity = "1";
    });
}

/* CANCEL */
function cancelEdit(id){
    const row = document.getElementById(`row-${id}`);
    const cells = row.querySelectorAll(".editable");

    cells.forEach((cell, index) => {
        cell.innerText = originalData[id][index];
    });

    toggleButtons(row, false);
}

/* BUTTON TOGGLE */
function toggleButtons(row, isEditing){
    row.querySelector(".edit-btn").style.display = isEditing ? "none" : "inline-block";
    row.querySelector(".save-btn").style.display = isEditing ? "inline-block" : "none";
    row.querySelector(".cancel-btn").style.display = isEditing ? "inline-block" : "none";
}


// ===============================
// AUTO LOAD
// ===============================

window.onload = function() {
    getStudents();
};
