<%@page import="in.co.rays.proj4.util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.proj4.controller.UserRegistrationCtl"%>
<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@page import="in.co.rays.proj4.controller.BaseCtl"%>
<%@page import="in.co.rays.proj4.controller.ORSView"%>
<%@page import="in.co.rays.proj4.util.DataUtility"%>


<!DOCTYPE html>

<html>

<head>
.
<meta name="viewport" content="width=device-width, initial-scale=1">


<title>Registration</title>

<!-- Bootstrap Icons -->
<link rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>

<body>

    <%@ include file="Header.jsp"%>


    <%

    String _suc = ServletUtility.getSuccessMessage(request);

    String _err = ServletUtility.getErrorMessage(request);
    
    HashMap <String,String> map = new HashMap<String,String>();
    map.put("male","male");
    map.put("female","female");

    %>
    
    <jsp:useBean id="bean" class="in.co.rays.proj4.bean.UserBean"
		scope="request"></jsp:useBean>
    


    <!-- REGISTRATION BACKGROUND -->

    <div class="position-relative overflow-hidden bg-light"
         style="min-height: 80vh; padding-top: 40px; padding-bottom: 50px;">


        <!-- BACKGROUND ACADEMIC ICONS -->

        <i class="bi bi-book position-absolute text-primary"
           style="
           font-size: 120px;
           opacity: 0.06;
           top: 30px;
           left: 7%;">
        </i>


        <i class="bi bi-mortarboard-fill position-absolute text-primary"
           style="
           font-size: 150px;
           opacity: 0.06;
           top: 50px;
           right: 7%;">
        </i>


        <i class="bi bi-laptop position-absolute text-primary"
           style="
           font-size: 120px;
           opacity: 0.05;
           bottom: 30px;
           left: 8%;">
        </i>


        <i class="bi bi-journal-bookmark-fill position-absolute text-primary"
           style="
           font-size: 120px;
           opacity: 0.05;
           bottom: 40px;
           right: 9%;">
        </i>


        <!-- REGISTRATION CARD -->
        <!-- FIX: card width thoda badhaya (col-lg-7) taaki 2-column rows me fields
             sahi se fit ho jayein aur card zyada lamba na dikhe -->

        <div class="container position-relative">

            <div class="row justify-content-center">

                <div class="col-md-9 col-lg-7">


                    <div class="card shadow-lg border-0">


                        <!-- CARD HEADER -->

                        <div class="card-header bg-white text-center py-3">

                            <h3 class="mb-1 text-primary">

                                <i class="bi bi-person-plus-fill"></i>

                                Registration

                            </h3>

                            <small class="text-muted">

                                Create your ORS account

                            </small>

                        </div>


                        <!-- CARD BODY -->

                        <div class="card-body p-4">


                            <!-- SUCCESS MESSAGE -->

                            <% if (_suc != null && !_suc.isEmpty()) { %>

                                <div class="alert alert-success" role="alert">

                                    <i class="bi bi-check-circle-fill"></i>

                                    <%= _suc %>

                                </div>

                            <% } %>


                            <!-- ERROR MESSAGE -->

                            <% if (_err != null && !_err.isEmpty()) { %>

                                <div class="alert alert-danger" role="alert">

                                    <i class="bi bi-exclamation-triangle-fill"></i>

                                    <%= _err %>

                                </div>

                            <% } %>


                            <form action="<%=ORSView.USER_REGISTRATION_CTL%>"
                                  method="post">


                                <!-- FIRST NAME + LAST NAME : ab ek hi row me side-by-side,
                                     card ki height kam karne ke liye -->
                                <div class="row">

                                    <div class="col-md-6 mb-3">

                                        <label class="form-label fw-bold">

                                            <i class="bi bi-person-fill text-primary"></i>

                                            First Name

                                            <font color="red">*</font>

                                        </label>


                                        <input type="text"
                                               name="firstName"
                                               value="<%=DataUtility.getStringData(bean.getFirstName())%>"
                                               placeholder="Enter your first name"
                                               class="form-control">


                                        <div class="text-danger mt-1">

                                            <%=ServletUtility.getErrorMessage("firstName", request)%>

                                        </div>

                                    </div>


                                    <div class="col-md-6 mb-3">

                                        <label class="form-label fw-bold">

                                            <i class="bi bi-person-fill text-success"></i>

                                            Last Name

                                            <font color="red">*</font>

                                        </label>


                                        <input type="text"
                                               name="lastName"
                                               value="<%=DataUtility.getStringData(bean.getLastName())%>"
                                               placeholder="Enter your last name"
                                               class="form-control">


                                        <div class="text-danger mt-1">

                                            <%=ServletUtility.getErrorMessage("lastName", request)%>

                                        </div>

                                    </div>

                                </div>


                                <!-- LOGIN -->

                                <div class="mb-3">

                                    <label class="form-label fw-bold">

                                        <i class="bi bi-person-circle text-info"></i>

                                        Login

                                        <font color="red">*</font>

                                    </label>


                                    <input type="email"
                                           name="login"
                                           value="<%=DataUtility.getStringData(bean.getLogin())%>"
                                           placeholder="Enter valid login ID"
                                           class="form-control">


                                    <div class="text-danger mt-1">

                                        <%=ServletUtility.getErrorMessage("login", request)%>

                                    </div>

                                </div>


                                <!-- PASSWORD + CONFIRM PASSWORD : side-by-side -->
                                <div class="row">

                                    <div class="col-md-6 mb-3">

                                        <label class="form-label fw-bold">

                                            <i class="bi bi-lock-fill text-warning"></i>

                                            Password

                                            <font color="red">*</font>

                                        </label>


                                        <input type="password"
                                               name="password"
                                               value="<%=DataUtility.getStringData(bean.getPassword())%>"
                                               placeholder="Enter password"
                                               class="form-control">


                                        <div class="text-danger mt-1">

                                            <%=ServletUtility.getErrorMessage("password", request)%>

                                        </div>

                                    </div>


                                    <div class="col-md-6 mb-3">

                                        <label class="form-label fw-bold">

                                            <i class="bi bi-shield-lock-fill text-danger"></i>

                                            Confirm Password

                                            <font color="red">*</font>

                                        </label>


                                        <input type="password"
                                               name="confirmPassword"
                                               value="<%=DataUtility.getStringData(bean.getConfirmPassword())%>"
                                               placeholder="Re-enter your password"
                                               class="form-control">


                                        <div class="text-danger mt-1">

                                            <%=ServletUtility.getErrorMessage("confirmPassword", request)%>

                                        </div>

                                    </div>

                                </div>


                                <!-- GENDER + DOB : side-by-side -->
                                <div class="row">

                                    <div class="col-md-6 mb-3">

                                        <label class="form-label fw-bold">

                                            <i class="bi bi-gender-ambiguous text-success"></i>

                                            Gender

                                            <font color="red">*</font>

                                        </label>


                                     <%=HTMLUtility.getList("gender", DataUtility.getStringData(bean.getGender()), map) %>


                                        <div class="text-danger mt-1">

                                            <%=ServletUtility.getErrorMessage("gender", request)%>

                                        </div>

                                    </div>


                                    <div class="col-md-6 mb-4">

                                        <label class="form-label fw-bold">

                                            <i class="bi bi-calendar-event-fill text-primary"></i>

                                            DOB

                                            <font color="red">*</font>

                                        </label>


                                        <input type="date"
                                               name="dob"
                                               value=""
                                               class="form-control">


                                        <div class="text-danger mt-1">

                                            <%=ServletUtility.getErrorMessage("dob", request)%>

                                        </div>

                                    </div>

                                </div>


                                <!-- SIGN UP BUTTON -->

                                <div class="text-center">

                                    <input type="submit"
                                           name="operation"
                                           value="<%=UserRegistrationCtl.OP_SIGN_UP%>"
                                           class="btn btn-primary px-4">

                                </div>


                            </form>

                        </div>

                    </div>

                </div>

            </div>

        </div>

    </div>


    <%@ include file="Footer.jsp"%>

</body>

</html>