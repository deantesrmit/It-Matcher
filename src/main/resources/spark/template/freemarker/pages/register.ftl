<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Register">
<#include "../fragment/banner.html">
<div class="container">
    <div class="row justify-content-center">
        <div class = "row">
            <div class = "col"> </div>
                <div class = "col-12 col-md-auto">
                    <h4 id ="login">Register for IT Matcher</h4>
                        <div class="form-register">
                            <input type="text" id="email" class="form-control input-sm chat-input" placeholder="Email Address" />
                            </br>
                            <input type="text" id="userPassword" class="form-control input-sm chat-input" placeholder="Password" />
                            </br>
                            <input type="text" id="firstName" class="form-control input-sm chat-input" placeholder="First Name" />
                            </br>
                            <input type="text" id="lastName" class="form-control input-sm chat-input" placeholder="Last Name" />
                            </br>
                            <label for="registerType">Registration Type</label>
                            <select class ="form-control" id = "registrationType">
                            <option>Job Lister</option>
                            <option>Freelancer</option>
                            </select>
                            </br>
                            <div class="wrapper">
                                <span class="group-btn">
                                    <a href="#" class="btn btn-primary btn-md">Register<i class="fa fa-sign-in"></i></a>

                                </span>
                            </div>
                        </div>
                </div>
            <div class = "col"></div>
        </div>
    </div>
</div>
</@layout.masterTemplate>
