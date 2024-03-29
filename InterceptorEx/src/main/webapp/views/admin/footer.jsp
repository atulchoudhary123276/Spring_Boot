       <footer>
            <p>&copy; 2024 Blood Bank. All rights reserved @Kashif.</p>
       </footer>
    </div>
    <script>
        document.getElementById("filterOption").addEventListener("change", function() {
            var selectedOption = this.value;
            var usernameInput = document.getElementById("usernameInput");
            var startDateInput = document.getElementById("startDate");
            var endDateInput = document.getElementById("endDate");

            if (selectedOption === "byUsername") {
                usernameInput.style.display = "inline-block";
                startDateInput.style.display = "none";
                endDateInput.style.display = "none";
            } else if (selectedOption === "createdBetween") {
                startDateInput.style.display = "inline-block";
                endDateInput.style.display = "inline-block";
                usernameInput.style.display = "none";
            } else {
                startDateInput.style.display = "none";
                endDateInput.style.display = "none";
                usernameInput.style.display = "none";
            }
        });
    </script>


</body>
</html>