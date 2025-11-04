async function submitData() {
    // Get form values
    const name = document.getElementById("name").value.trim();
    const email = document.getElementById("email").value.trim();
    const lineOne = document.getElementById("lineOne").value.trim();
    const lineTwo = document.getElementById("lineTwo").value.trim();
    const cityId = document.getElementById("cityId").value.trim();

    // Create the JSON object to send
    const studentData = {
        name: name,
        email: email,
        lineOne: lineOne,
        lineTwo: lineTwo,
        cityId: cityId
    };

    try {
        const response = await fetch("http://localhost:8080/hibernate_practical/student", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(studentData)
        });

        if (response.ok) {
            const result = await response.json(); // assuming the backend returns JSON
            console.log("✅ Student added successfully:", result);
            alert("Student added successfully!");
            // Optionally clear the form
            document.getElementById("studentForm").reset();
        } else {
            console.error("❌ Server error:", response.status, response.statusText);
            alert("Error: Could not add student. Please try again.");
        }
    } catch (error) {
        console.error("⚠️ Network error:", error);
        alert("Failed to connect to the server. Please check your connection or backend.");
    }
}
