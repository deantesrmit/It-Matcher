<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="View Jobs">
    <#include "../fragment/banner.html">
<div class="container">

    <div class="row justify-content-center">
        <h2>Job #<#if job.id??>"${job.id}"</#if></h2>
        <div class = "col-12 col-md-auto">
            <h4>Job Description</h4>
            <p><#if job.description??>"${job.description}"</#if></p>
            <p>Contact <#if>job.freelancerID</#if></p>
        </div>

    </div>

</div>

</@layout.masterTemplate>