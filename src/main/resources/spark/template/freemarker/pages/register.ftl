<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Register">
<#include "../fragment/banner.html">
<div class="container">
        <div class="row justify-content-center">
            <div class = "row">
                <div class = "col"> </div>
                    <div class = "col-12 col-md-auto">
                        <h4 id ="login">Register for IT Matcher</h4>
                            <form class="form-register"  action="/register/" method="POST">
                                <input type="text" name="username" class="form-control input-sm chat-input" placeholder="Username Address" />
                                </br>
                                <input type="text" name="email" class="form-control input-sm chat-input" placeholder="Email Address" />
                                </br>
                                <input type="password" name="password" class="form-control input-sm chat-input" placeholder="Password" />
                                </br>
                                <input type="text" name="first" class="form-control input-sm chat-input" placeholder="First Name" />
                                </br>
                                <input type="text" name="lastname" class="form-control input-sm chat-input" placeholder="Last Name" />
                                </br>
                                <label for="registerType">Registration Type</label>
                                <select class ="form-control" name="registrationType">
                                    <option value="FREELANCER">Job Lister</option>
                                    <option value="POSTER">Freelancer</option>
                                </select>
                                </br>
                                <div class="wrapper">
                                    <span class="group-btn">
                                        <button href="#" class="btn btn-primary btn-md">Register<i class="fa fa-sign-in"></i></button>

                                    </span>
                                </div>
                            </form>
                    </div>
                <div class = "col"></div>
            </div>
        </div>
</div>
</@layout.masterTemplate>
