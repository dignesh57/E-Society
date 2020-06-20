<?php
include('header.php');
?>

            <!-- main-heading -->
            <h2 class="main-title-w3layouts mb-2 text-center">Widgets</h2>
            <!--// main-heading -->

            <div class="container-fluid">
                <div class="row">
                    <!-- Stats -->
                    <div class="outer-w3-agile col-xl">
                        <div class="work-progres">
                            <h4 class="tittle-w3-agileits mb-4">Recent Followers</h4>
                            <hr>
                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Project</th>
                                            <th>Manager</th>

                                            <th>Status</th>
                                            <th>Progress</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>Face book</td>
                                            <td>Alexander</td>

                                            <td>
                                                <span class="badge badge-danger">in progress</span>
                                            </td>
                                            <td>
                                                <span class="badge badge-pill badge-primary">70%</span>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>Twitter</td>
                                            <td>Lucika adam</td>

                                            <td>
                                                <span class="badge badge-success">completed</span>
                                            </td>
                                            <td>
                                                <span class="badge badge-pill badge-primary">80%</span>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>3</td>
                                            <td>Google</td>
                                            <td>Michael</td>

                                            <td>
                                                <span class="badge badge-warning">in progress</span>
                                            </td>
                                            <td>
                                                <span class="badge badge-pill badge-info">30%</span>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>4</td>
                                            <td>LinkedIn</td>
                                            <td>Chris dany</td>

                                            <td>
                                                <span class="badge badge-info">in progress</span>
                                            </td>
                                            <td>
                                                <span class="badge badge-pill badge-secondary">55%</span>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>5</td>
                                            <td>Tumblr</td>
                                            <td>Jacob velly</td>

                                            <td>
                                                <span class="badge badge-warning">in progress</span>
                                            </td>
                                            <td>
                                                <span class="badge badge-pill badge-primary">75%</span>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>6</td>
                                            <td>Tesla</td>
                                            <td>Donald chris</td>

                                            <td>
                                                <span class="badge badge-info">in progress</span>
                                            </td>
                                            <td>
                                                <span class="badge badge-pill badge-info">25%</span>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>7</td>
                                            <td>Behance</td>
                                            <td>alexa louis</td>

                                            <td>
                                                <span class="badge badge-info">in progress</span>
                                            </td>
                                            <td>
                                                <span class="badge badge-pill badge-success">100%</span>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!--// Stats -->
                    <!-- Pie-chart -->
                    <div class="outer-w3-agile col-xl ml-xl-3 mt-xl-0 mt-3 report">
                        <h4 class="tittle-w3-agileits mb-4">Rerport</h4>
                        <div class="widget widget-report-w3-table">
                            <div class="widget-header row justify-content-between mb-3">
                                <div class="col">
                                    <h3>August 2018</h3>
                                </div>
                                <div class="col">
                                    <h3 class="text-right">$29,228</h3>
                                </div>
                            </div>

                            <div class="widget-body p-15">
                                <table class="table table-bordered">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Name</th>
                                            <th>Amount</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>2356</td>
                                            <td>dummy text </td>
                                            <td>6,200.00</td>
                                        </tr>
                                        <tr>
                                            <td>4589</td>
                                            <td>Lorem Ipsum</td>
                                            <td>6,500.00</td>
                                        </tr>

                                        <tr>
                                            <td>3269</td>
                                            <td>specimen book</td>
                                            <td>6,800.00</td>
                                        </tr>
                                        <tr>
                                            <td>5126</td>
                                            <td>Letraset sheets</td>
                                            <td>7,200.00</td>
                                        </tr>
                                        <tr>
                                            <td>7425</td>
                                            <td>PageMaker</td>
                                            <td>5,900.00</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!--// Pie-chart -->
                </div>
            </div>
            <!-- Simple-chart -->
            <div class="outer-w3-agile mt-3">
                <h4 class="tittle-w3-agileits mb-4">Weather widget</h4>
                <div class="main-info">
                    <div class="weather-top d-flex justify-content-between">
                        <div class="weather-grids-w3-agile">
                            <h3 class="fri">Friday </h3>
                            <h3>Weather</h3>
                        </div>
                        <div class="weather-grids-w3-agile weather-mdl">
                            <canvas id="clear-day"></canvas>
                        </div>
                        <div class="weather-grids-w3-agile">
                            <h4>Max 27°</h4>
                            <h3>21°C</h3>
                            <h4>Min 10°</h4>
                        </div>
                    </div>
                    <div class="weather-bottom">
                        <ul class="d-sm-flex justify-content-around">
                            <li class="bg">
                                <h4>FRI</h4>
                                <figure class="icons">
                                    <canvas id="clear-night" width="40" height="40"></canvas>
                                </figure>
                                <h5>27°C</h5>
                                <h6>17°C</h6>
                            </li>
                            <li>
                                <h4>SAT</h4>
                                <figure class="icons">
                                    <canvas id="partly-cloudy-day" width="40" height="40"></canvas>
                                </figure>
                                <h5>20°C</h5>
                                <h6>15°C</h6>
                            </li>
                            <li class="bg">
                                <h4>SUN</h4>
                                <figure class="icons">
                                    <canvas id="cloudy" width="40" height="40"></canvas>
                                </figure>
                                <h5>18°C</h5>
                                <h6>12°C</h6>
                            </li>
                            <li>
                                <h4>MON</h4>
                                <figure class="icons">
                                    <canvas id="sleet" width="40" height="40"></canvas>
                                </figure>
                                <h5>17°C</h5>
                                <h6>12°C</h6>
                            </li>
                            <li class="bg">
                                <h4>TUE</h4>
                                <figure class="icons">
                                    <canvas id="rain" width="40" height="40"></canvas>
                                </figure>
                                <h5>17°C</h5>
                                <h6>10°C</h6>
                            </li>
                            <li>
                                <h4>WED</h4>
                                <figure class="icons">
                                    <canvas id="snow" width="40" height="40"></canvas>
                                </figure>
                                <h5>24°C</h5>
                                <h6>10°C</h6>
                            </li>
                            <li class="bg">
                                <h4>THR</h4>
                                <figure class="icons">
                                    <canvas id="wind" width="40" height="40"></canvas>
                                </figure>
                                <h5>25°C</h5>
                                <h6>15°C</h6>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <!--// Simple-chart -->

            <!--// three-grids -->
            <div class="container-fluid">
                <div class="row">
                    <!-- Profile -->
                    <div class="outer-w3-agile col-xl mt-3">
                        <div class="profile-main-w3ls">
                            <div class="profile-pic wthree">
                                <img src="images/profile.jpg" class="img-fluid" alt="Responsive image">
                                <h3>Andy Brown</h3>
                                <p>Creative Designer</p>
                            </div>
                            <div class="w3-message">
                                <h5>About Me</h5>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec erat sapien, lobortis id felis
                                    eu, egestas venenatis nisl.</p>
                                <div class="w3ls-touch">

                                    <div class="social">
                                        <ul>
                                            <li>
                                                <a href="#">
                                                    <i class="fab fa-facebook-f"></i>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <i class="fab fa-twitter"></i>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <i class="fab fa-linkedin-in"></i>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <i class="fab fa-google-plus-g"></i>
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                    <!--// Profiile -->
                    <!-- Contacts -->
                    <div class="outer-w3-agile col-xl mt-3 mx-xl-3">
                        <div class="agileinfo-cdr">
                            <h4 class="tittle-w3-agileits mb-4">Contacts</h4>
                            <hr>
                            <div class="card-body">
                                <div class="list-group">
                                    <a class="list-group-item media d-flex justify-content-between align-items-center" href="">
                                        <div class="contact-wdgt-left">
                                            <img src="images/c1.jpg" class="img-fluid" alt="Responsive image">
                                        </div>
                                        <div class="media-body d-flex justify-content-between align-items-center">
                                            <div class="contact-wdgt-left">
                                                <div class="lg-item-heading">Alexander</div>
                                                <small class="lg-item-text">example@gmail.com</small>
                                            </div>
                                            <div class="contact-wdgt-right">
                                                <div class="lg-item-heading">Ceo</div>
                                            </div>
                                        </div>
                                    </a>
                                    <a class="list-group-item media d-flex justify-content-between align-items-center mt-4" href="">
                                        <div class="contact-wdgt-left">
                                            <img src="images/c2.jpg" class="img-fluid" alt="Responsive image">
                                        </div>
                                        <div class="media-body d-flex justify-content-between align-items-center">
                                            <div class="contact-wdgt-left">
                                                <div class="lg-item-heading">Jackson Jacob</div>
                                                <small class="lg-item-text">example1@gmail.com</small>
                                            </div>
                                            <div class="contact-wdgt-right">
                                                <div class="lg-item-heading">Director</div>
                                            </div>
                                        </div>
                                    </a>
                                    <a class="list-group-item media d-flex justify-content-between align-items-center mt-4" href="">
                                        <div class="contact-wdgt-left">
                                            <img src="images/c3.jpg" class="img-fluid" alt="Responsive image">
                                        </div>
                                        <div class="media-body d-flex justify-content-between align-items-center">
                                            <div class="contact-wdgt-left">
                                                <div class="lg-item-heading">Merina lisa</div>
                                                <small class="lg-item-text">example2@gmail.com</small>
                                            </div>
                                            <div class="contact-wdgt-right">
                                                <div class="lg-item-heading">Manager</div>
                                            </div>
                                        </div>
                                    </a>
                                    <a class="list-group-item media d-flex justify-content-between align-items-center mt-4" href="">
                                        <div class="contact-wdgt-left">
                                            <img src="images/c4.jpg" class="img-fluid" alt="Responsive image">
                                        </div>
                                        <div class="media-body d-flex justify-content-between align-items-center">
                                            <div class="contact-wdgt-left">
                                                <div class="lg-item-heading">Michael</div>
                                                <small class="lg-item-text">example3@gmail.com</small>
                                            </div>
                                            <div class="contact-wdgt-right">
                                                <div class="lg-item-heading">Assistant</div>
                                            </div>
                                        </div>
                                    </a>


                                </div>
                            </div>
                        </div>
                    </div>
                    <!--// Contacts -->
                    <!-- Activities -->
                    <div class="outer-w3-agile col-xl mt-3">
                        <h4 class="tittle-w3-agileits mb-4">Activities</h4>
                        <div class="card-body card-padding">
                            <div class="">
                                <hr>
                                <div class="widget-body">
                                    <div class="streamline">
                                        <div class="sl-item border-left border-danger">
                                            <div class="sl-content">
                                                <small class="text-muted">0 mins ago</small>
                                                <p>Alexander has just joined</p>
                                            </div>
                                        </div>
                                        <div class="sl-item border-left border-primary">
                                            <div class="sl-content">
                                                <small class="text-muted">15 minutes ago</small>
                                                <p>Michael has sent a request for access</p>
                                            </div>
                                        </div>
                                        <div class="sl-item border-left border-success">
                                            <div class="sl-content">
                                                <small class="text-muted">18 minutes ago</small>
                                                <p>chris added you to his team</p>
                                            </div>
                                        </div>
                                        <div class="sl-item border-left border-secondary">
                                            <div class="sl-content">
                                                <small class="text-muted">22 minutes ago</small>
                                                <p>jackson has finished his task</p>
                                            </div>
                                        </div>
                                        <div class="sl-item border-left border-warning">
                                            <div class="sl-content">
                                                <small class="text-muted">30 minutes ago</small>
                                                <p>Jacob shared a folder with you</p>
                                            </div>
                                        </div>

                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                    <!--// Activities -->
                </div>
            </div>
            <!--// Three-grids -->
            
           <?php
include('footer.php');
?>