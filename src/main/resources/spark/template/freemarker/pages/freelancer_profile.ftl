<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Profile">
<#include "../fragment/banner.html">
<div class="container" xmlns="http://www.w3.org/1999/html">
        <div class="row justify-content-center">
            <div class = "row">
                <div class = "col"> </div>
                <div class = "col-12 col-md-auto">
                    <!-- Edit this to pull Freelancer name from database -->
                    <h2>${users.firstName} ${users.lastName} Freelancer Profile</h2>
                </div>
                <div class = "col"></div>
            </div>
        </div>

        <div class="row pad-top">
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4><strong>User Information</strong></h4>
                    </div>
                    <div class="panel-body">
                        <table class="table">

                            </br>
                            <tbody>

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
            <div class="col-md-6">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4><strong>List of Job Offers</strong></h4>
                    </div>
                    <div class="panel-body">
                        <!-- Edit this to pull applied jobs from database -->
                        <a href="/viewMatches" <button class="btn btn-success">View Job Offers</button></a>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>


</@layout.masterTemplate>
