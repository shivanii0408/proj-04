<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Welcome Page</title>

    <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

    <style>
        body {
            margin: 0;
            background: #ffffff;
            font-family: Arial, sans-serif;
        }

        /* FULL SCREEN BACKGROUND */
        .welcome-section {
            min-height: 85vh;
            padding: 65px 20px;
            background: linear-gradient(
                135deg,
                #ffffff 0%,
                #f2f7ff 55%,
                #e6efff 100%
            );
            position: relative;
            overflow: hidden;
        }

        /* BACKGROUND DECORATION */
        .bg-circle {
            position: absolute;
            border-radius: 50%;
            background: #2563eb;
            opacity: 0.045;
            pointer-events: none;
        }

        .circle-one {
            width: 350px;
            height: 350px;
            top: -120px;
            right: -80px;
        }

        .circle-two {
            width: 280px;
            height: 280px;
            bottom: -100px;
            left: -80px;
        }

        /* MAIN CARD */
        .welcome-card {
            border: 1px solid #e3ebf8;
            border-radius: 24px;
            overflow: hidden;
            background: #ffffff;
            box-shadow: 0 15px 45px rgba(37, 99, 235, 0.08);
        }

        /* CARD TOP SECTION */
        .welcome-top {
            padding: 35px 20px 25px;
            background: #ffffff;
            border-bottom: 1px solid #edf2fa;
        }

        .main-icon {
            width: 76px;
            height: 76px;
            margin: 0 auto;
            display: flex;
            align-items: center;
            justify-content: center;
            border-radius: 22px;
            background: #edf4ff;
            color: #2563eb;
            font-size: 38px;
        }

        .welcome-title {
            color: #173b75;
            font-size: 34px;
            font-weight: 700;
            margin-top: 18px;
        }

        .welcome-subtitle {
            color: #7b8ba5;
            font-size: 13px;
            letter-spacing: 2px;
            text-transform: uppercase;
        }

        /* CARD CONTENT */
        .welcome-content {
            padding: 35px 40px 40px;
        }

        .hello-title {
            color: #1e293b;
            font-weight: 700;
            font-size: 27px;
        }

        .description {
            max-width: 540px;
            margin: 12px auto 30px;
            color: #64748b;
            line-height: 1.8;
        }

        /* FEATURE CARDS */
        .feature-box {
            padding: 24px 12px;
            height: 100%;
            background: #ffffff;
            border: 1px solid #e8eef8;
            border-radius: 16px;
            transition: all 0.25s ease;
        }

        .feature-box:hover {
            background: #f5f8ff;
            border-color: #c7d9ff;
            transform: translateY(-4px);
        }

        .feature-icon {
            font-size: 29px;
            color: #2563eb;
            margin-bottom: 12px;
        }

        .feature-title {
            color: #263b5c;
            font-size: 15px;
            font-weight: 700;
            margin-bottom: 7px;
        }

        .feature-text {
            color: #8290a5;
            font-size: 12px;
            margin-bottom: 0;
        }

        /* LOGIN STATUS */
        .login-status {
            border-radius: 10px;
            font-size: 14px;
            text-align: left;
            padding: 14px 18px;
        }

        @media (max-width: 576px) {
            .welcome-section {
                padding: 35px 12px;
            }

            .welcome-content {
                padding: 25px 18px;
            }

            .welcome-title {
                font-size: 28px;
            }

            .hello-title {
                font-size: 23px;
            }
        }
    </style>
</head>

<body>

    <%@ include file="Header.jsp"%>

    <!-- FULL SCREEN WELCOME BACKGROUND -->
    <section class="welcome-section">

        <div class="bg-circle circle-one"></div>
        <div class="bg-circle circle-two"></div>

        <div class="container position-relative">

            <div class="row justify-content-center">
                <div class="col-lg-9 col-xl-8">

                    <!-- WELCOME CARD -->
                    <div class="welcome-card">

                        <!-- CARD HEADER -->
                        <div class="welcome-top text-center">

                            <div class="main-icon">
                                <i class="bi bi-mortarboard"></i>
                            </div>

                            <h1 class="welcome-title">
                                Welcome to ORS
                            </h1>

                            <p class="welcome-subtitle mb-0">
                                Online Result System
                            </p>

                        </div>

                        <!-- CARD BODY -->
                        <div class="welcome-content text-center">

                            <h2 class="hello-title">

                                <% if (isLogin) { %>

                                    Hello <%= userBean.getFirstName() %>!

                                <% } else { %>

                                    Hello Guest!

                                <% } %>

                            </h2>

                            <p class="description">
                                A simple and organized way to manage students,
                                courses, subjects, colleges, examinations
                                and academic results.
                            </p>

                            <!-- FEATURE SECTION -->
                            <div class="row g-3">

                                <div class="col-md-4">
                                    <div class="feature-box">

                                        <i class="bi bi-people feature-icon"></i>

                                        <h6 class="feature-title">
                                            Students
                                        </h6>

                                        <p class="feature-text">
                                            Manage student records
                                        </p>

                                    </div>
                                </div>

                                <div class="col-md-4">
                                    <div class="feature-box">

                                        <i class="bi bi-journal-bookmark feature-icon"></i>

                                        <h6 class="feature-title">
                                            Courses
                                        </h6>

                                        <p class="feature-text">
                                            Organize course details
                                        </p>

                                    </div>
                                </div>

                                <div class="col-md-4">
                                    <div class="feature-box">

                                        <i class="bi bi-bar-chart feature-icon"></i>

                                        <h6 class="feature-title">
                                            Results
                                        </h6>

                                        <p class="feature-text">
                                            View academic results
                                        </p>

                                    </div>
                                </div>

                            </div>

                            <!-- LOGIN MESSAGE -->
                            <% if (isLogin) { %>

                                <div class="alert alert-success login-status mt-4 mb-0"
                                    role="alert">

                                    <i class="bi bi-check-circle-fill me-2"></i>
                                    You are successfully logged in.

                                </div>

                            <% } else { %>

                                <div class="alert alert-primary login-status mt-4 mb-0"
                                    role="alert">

                                    <i class="bi bi-info-circle-fill me-2"></i>
                                    Please login to access ORS features.

                                </div>

                            <% } %>

                        </div>
                    </div>

                </div>
            </div>
        </div>

    </section>

    <%@ include file="Footer.jsp"%>

</body>
</html>
