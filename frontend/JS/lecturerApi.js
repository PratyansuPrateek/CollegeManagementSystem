// ✅ ADD THIS LINE FIRST
let originalData = {};

// ===============================
// GET ALL LECTURERS
// ===============================

function getLecturers(){

const table = document.getElementById("lecturerTable");
if(!table) return;

fetch("http://localhost:8080/lecturer/getAll")
.then(res => res.json())
.then(data => {

table.innerHTML = "";

data.forEach(l => {
table.innerHTML += `
<tr id="row-${l.id}">
<td>${l.id}</td>
<td class="editable">${l.name}</td>
<td class="editable">${l.subject}</td>
<td class="editable">${l.mail}</td>

<td>
<button class="edit-btn" onclick="editRow(${l.id})">Edit</button>
<button class="save-btn" onclick="saveRow(${l.id})" style="display:none;">Save</button>
<button class="cancel-btn" onclick="cancelEdit(${l.id})" style="display:none;">Cancel</button>
<button class="delete-btn" onclick="deleteLecturer(${l.id})">Delete</button>
</td>
</tr>
`;
});
});
}


// ===============================
// DELETE
// ===============================

function deleteLecturer(id){
fetch(`http://localhost:8080/lecturer/deleteLecturer?id=${id}`, {
method:"DELETE"
})
.then(()=> getLecturers());
}


// ===============================
// INLINE EDIT (IMPORTANT 🔥)
// ===============================

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
        subject: inputs[1].value,
        mail: inputs[2].value
    };

    row.style.opacity = "0.5";

    fetch(`http://localhost:8080/lecturer/updateLecturer/${id}`, {
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
        cells[1].innerText = updatedData.subject;
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

window.onload = function(){
getLecturers();
};