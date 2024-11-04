function appendToDisplay(value) {
    document.getElementById("display").value += value;
}

function clearDisplay() {
    document.getElementById("display").value = "";
}

function deleteLast() {
    let display = document.getElementById("display");
    display.value = display.value.slice(0, -1);
}

function setOperator(op) {
    document.getElementById("num1").value = document.getElementById("display").value;
    document.getElementById("operator").value = op;
    clearDisplay();
}

function calculateResult() {
    const num1 = document.getElementById("num1").value;
    const num2 = document.getElementById("display").value;
    const operator = encodeURIComponent(document.getElementById("operator").value);

    fetch(`/calculator/calculate?num1=${num1}&num2=${num2}&operator=${operator}`)
        .then(response => response.json())
        .then(data => {
            if (data.error) {
                document.getElementById("display").value = data.error;
            } else {
                document.getElementById("display").value = data.result;
            }
        })
        .catch(error => console.error("Error:", error));
}
