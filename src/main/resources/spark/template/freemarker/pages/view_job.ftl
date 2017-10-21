<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="View Job">
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-offset-5 col-md-4">
            <h4 id="login">View Job ${job.id}</h4>
            <a href="/viewFreelancers/${job.id}/" <button class="btn btn-success btn-block">View Freelancers</button></a>
        </div>
    </div>
    <a href="/profile/"><button class="btn btn-success">Back</button> </a>
</div>
</@layout.masterTemplate>