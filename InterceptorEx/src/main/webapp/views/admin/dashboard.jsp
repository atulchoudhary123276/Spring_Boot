<jsp:include page="header.jsp" />

<div class="main">
    <aside class="sidebar">
        <ul>
            <li><a href="/dashboard" class="active">Dashboard</a></li>
            <li><a href="/dashboard/agent-account-creation">Register Agent</a></li>
            <li><a href="/dashboard/enduser-lists">EndUsers List</a></li>
            <li><a href="/dashboard/blood-request">Requests</a></li>

        </ul>
    </aside>

    <main class="content">
        <h1>Welcome to Admin Dashboard</h1>
        <h2 style="color:green"> ${success} </h2>
            <div class="admin-profile">
                <h2>Admin Profile</h2>
                <p><strong>Name:</strong> ${data.name}</p>
                <p><strong>Username:</strong> ${data.username}</p>
                <p><strong>Created At:</strong> ${data.creationTime}</p>
                <p><strong>Created By:</strong> ${data.createdBy}</p>
                <p><strong>DOB:</strong> ${data.dob}</p>
                <p><strong>Blood Group:</strong> ${data.bloodGroup}</p>
            </div>
    </main>
</div>
<jsp:include page="footer.jsp" />