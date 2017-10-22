<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="List_Jobs">
<div class="container">

    <h1>Matched Job for id ${job.id}</h1>
    <br/>
    <br/>
    <br/>
    <h2 class="lead"><strong class="text-danger">3</strong> Job were found!</strong></h2>
    <br/>
    <br/>

    <section class="col-xs-12 col-sm-6 col-md-12">

                <div class="col-xs-12 col-sm-12 col-md-3">
                    <ul class="meta-search">
                    <span>${job.description}</span>
                    </ul>
                </div>

    </section>


</div>
</@layout.masterTemplate>