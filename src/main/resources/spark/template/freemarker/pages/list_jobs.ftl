<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="List_Jobs">
<div class="container">

    <h1>Matched Jobs for Freelancer ${freelancer.id}</h1>
    <br/>
    <br/>
    <br/>
    <h2 class="lead"><strong class="text-danger">3</strong> Jobs were found!</strong></h2>
    <br/>
    <br/>

    <section class="col-xs-12 col-sm-6 col-md-12">
        <#list jobs as scoredJob>
            <#assign job = scoredJob.job>
            <article class="search-result row">
                <div class="col-xs-11 col-md-1">
                    <span>Score:${scoredJob.score} </span>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-3">
                    <ul class="meta-search">
                    <span>${job.description}</span>
                    </ul>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-5 excerpet">
            </article>
        </#list>
        <a href="/job/${job.id}/"><button class="btn btn-success">Back</button> </a>
    </section>


</div>
</@layout.masterTemplate>