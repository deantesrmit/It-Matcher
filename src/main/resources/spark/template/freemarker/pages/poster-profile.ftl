<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Profile">
<#include "../fragment/banner.html">
<div class="container">
        <div class="row justify-content-center">
            <div class = "row">
                <div class = "col"> </div>
                <div class = "col-12 col-md-auto">
                    <!-- Edit this to pull Freelancer name from database -->
                    <h2>Job Poster Profile</h2>
                </div>
                <div class = "col"></div>
            </div>
        </div>

        <div class="row pad-top">
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4><strong>List of your Jobs/Applicants</strong></h4>
                    </div>
                    <div class="panel-body">
                        <#list jobs as job>
                            <a href="/viewFreelancers/${job.id}/" <button class="btn btn-success btn-block">${job.title}</button></a>
                        </#list>
                            <a href="/create_job/" <button class="btn btn-warning btn-block">Post New Job</button></a>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4><strong>User Information</strong></h4>
                    </div>
                    <div class="panel-body">
                        <!-- Edit this to pull user info from database -->
                        <table class="table">

                            </br>
                            <tbody>
                            <tr>
                                <td>User ID:</td>
                                <td>${users.id!}</td>
                            </tr>
                            <tr>
                                <td>User Name:</td>
                                <td>${users.username!}</td>
                            </tr>
                            <tr>
                                <td>First Name:</td>
                                <td>${users.firstName!}</td>
                            </tr>
                            <tr>
                                <td>Last Name:</td>
                                <td>${users.lastName!}</td>
                            </tr>
                            <tr>
                                <td>Address:</td>
                                <td>${profile.address1!}</td>
                            </tr>
                            <tr>
                                <td>Suburb:</td>
                                <td>${profile.suburb!}</td>
                            </tr>
                            <tr>
                                <td>State:</td>
                                <td>${profile.state!}</td>
                            </tr>
                            <tr>
                                <td>Postcode:</td>
                                <td>${profile.postcode!}</td>
                            </tr>
                            <tr>
                                <td>Bio:</td>
                                <td>${profile.bio!}</td>
                            </tr>
                            <tr>
                                <td>WorkExperience:</td>
                                <td>${workExp.value!}</td>
                            </tr>
                            <tr>
                                <td>Education:</td>
                                <td>${education.value!}</td>
                            </tr>
                            </tbody>
                        </table>
                        <a href="/edit_profile/" <button class="btn btn-success">Edit User Information</button></a>
                    </div>
                </div>
            </div>
        </div>
</div>


</@layout.masterTemplate>
