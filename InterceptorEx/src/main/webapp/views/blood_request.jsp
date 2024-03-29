<jsp:include page="header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="main">
    <aside class="sidebar">
        <ul>
            <li><a href="/dashboard">Dashboard</a></li>
            <li><a href="/dashboard/agent-account-creation">Register Agent</a></li>
            <li><a href="/dashboard/enduser-lists">EndUsers List</a></li>
            <li><a href="/dashboard/blood-request" class="active">Requests</a></li>

        </ul>
    </aside>

    <main class="content">
        <div class="user-list">
            <h2 style="text-align:center">User Requested List</h2>
          <table class="user-list">
              <thead>
                  <tr>
                      <th>Serial No.</th>
                      <th>Username</th>
                      <th>Agent</th>
                      <th>Blood Group</th>
                      <th>Quantity</th>
                      <th>Type</th>
                      <th>Created At</th>
                      <th>DOB</th>
                      <th>Age</th>
                      <th>Status</th>
                  </tr>
              </thead>
              <tbody>
                  <c:forEach items="${bloodStocks}" var="bloodStock" varStatus="loop">
                      <tr>
                          <td>${loop.index + 1}</td>
                          <td>${bloodStock.username}</td>
                          <td>${bloodStock.agent}</td>
                          <td>${bloodStock.bloodGroup}</td>
                          <td>${bloodStock.quantity}</td>
                          <td>${bloodStock.type.toUpperCase()}</td>
                          <td>${bloodStock.createdAt}</td>
                          <td>${bloodStock.dob}</td>
                          <td>${bloodStock.age}</td>
                          <td>
                              <c:choose>
                                  <c:when test="${bloodStock.status eq 'pending'}">
                                      <div class="button-group">
                                          <form action="/dashboard/blood-request" method="POST">
                                              <input type="hidden" name="status" value="accepted">
                                              <input type="hidden" name="id" value="${bloodStock.id}">
                                              <button type="submit" class="btn accept-btn">Accept</button>
                                          </form>
                                          <form action="/dashboard/blood-request" method="POST">
                                              <input type="hidden" name="status" value="rejected">
                                              <input type="hidden" name="id" value="${bloodStock.id}">
                                              <button type="submit" class="btn reject-btn">Reject</button>
                                          </form>
                                      </div>
                                  </c:when>
                                  <c:when test="${bloodStock.status eq 'rejected'}">
                                      <span class="btn rejected-btn">Rejected</span>
                                  </c:when>
                                  <c:otherwise>
                                      <span class="btn accepted-btn">Accepted</span>
                                  </c:otherwise>
                              </c:choose>
                          </td>
                      </tr>
                  </c:forEach>
              </tbody>
          </table>
        </div>
    </main>
</div>
<jsp:include page="footer.jsp" />