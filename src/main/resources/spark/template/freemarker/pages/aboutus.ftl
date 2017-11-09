<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="About_Us">
    <#include "../fragment/banner.html">
<div class="container">

    <div class = "row">
        <div class = "col-md-6">
            <h4>Our Mission</h4>
            <p>To provide easy and fast employment options to Freelancers and Job Posters alike.</p>
            <p>We want to streamline the process of hiring the right person for a project, reducing the amount of time
             spent sifting through resumes.
            </p>
        </div>

        <div class = "col-md-6">
            <h4>About Us</h4>
            <p>The IT Matcher Team is a small Australian based group of University Students! The IT Matcher site is
                dedicated to finding the right developers for each and every project. IT Matcher was founded in 2017
                by a group of University Students as a Project for RMIT University.</p>
            <p>What makes IT Matcher Unique is that we cater solly to the IT industry. Our match-making system provides
                Job Posters with a list of developers uniquely suited to their needs and location. This allows Job
                Posters and Freelancers alike to easily find employment opportunities.</p>
        </div>
    </div>

</div>



</@layout.masterTemplate>
