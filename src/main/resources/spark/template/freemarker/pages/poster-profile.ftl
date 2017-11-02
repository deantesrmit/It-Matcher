<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Profile">
<#include "../fragment/banner.html">
<div class="container">
        <div class="row justify-content-center">
            <div class = "row">
                <div class = "col"> </div>
                <div class = "col-12 col-md-auto">
                    <!-- Edit this to pull Freelancer name from database -->
                    <h4>Job Poster Profile</h4>
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
                            <a href="/viewFreelancers/${job.id}/" <button class="btn btn-success btn-block">${job.id} - ${job.title}</button></a>
                        </#list>
                            <a href="/create_job/" <button class="btn btn-warning btn-block">New Job</button></a>
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
                        <p>User ID:<#if users.id??>${users.id}</#if></p>
                        <p>User Name: <#if users.username??>${users.username}</#if></p>
                        <p>First Name: <#if users.firstName??>${users.firstName}</#if></p>
                        <p>Last Name: <#if users.lastName??>${users.lastName}</#if> </p>
                        <p>Address: <#if profile.address1??>${profile.address1}</#if> </p>
                        <p>Suburb: <#if profile.suburb??>${profile.suburb}</#if> </p>
                        <p>State: <#if profile.state??>${profile.state}</#if> </p>
                        <p>Postcode: <#if profile.postcode??>${profile.postcode}</#if> </p>
                        <p>Bio: <#if profile.bio??>${profile.bio}</#if> </p>
                        <button class="btn btn-success">Edit User Information</button>
                    </div>
                </div>
            </div>
        </div>
</div>


</@layout.masterTemplate>
