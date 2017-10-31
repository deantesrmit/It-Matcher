<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Login">
<div class="container">

    <h1>Matched Freelancers for JOB ${job.id}</h1>
    <br/>
    <br/>
    <br/>
    <h2 class="lead"><strong class="text-danger">3</strong> IT proffesionals were found for the search for <strong
            class="text-danger">building a website</strong></h2>
    <br/>
    <br/>

    <section class="col-xs-12 col-sm-6 col-md-12">
        <#list freelancers as scoredFreelancer>
            <#assign freeLancer = scoredFreelancer.freeLancer>
            <article class="search-result row">
                <div class="col-xs-11 col-md-1">
                    <span>Score:${scoredFreelancer.score} </span>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-3">
                    <a href="#" title="no photo" class="thumbnail"><img src="../img/no-photo.jpg" alt="NO PHOTO"/></a>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-3">
                    <ul class="meta-search">
                        <li>
                            <span>
                                <#list freeLancer.languages as language>
                                    <span>${language.value}</span>
                                </#list>
                            </span>
                        </li>
                        <#--<li><span>${freeLancer.education!}</span></li>-->
                        <#--<li><span>${freeLancer.experience!}</span></li>-->
                        <li>
                            <span>
                                <#list freeLancer.skills as skill>
                                ${skill.value!},
                                </#list>
                            </span>
                        </li>

                    </ul>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-5 excerpet">
                    <h3><a href="#" title="">${freeLancer.name!}</a></h3>
                    <p>${freeLancer.bio}</p>
                    <form class="form-login" action="/viewFreelancers/${job.id}/" method="POST">
                        <input type="hidden" name="jobID" value="${job.id!}">
                        <input type="hidden" name="freelancerID" value="${freeLancer.id!}">
                    <input type="submit" class="btn btn-primary btn-md" value="Offer Job" />
                    </form>
                </div>
                <span class="clearfix borda"></span>
            </article>
        </#list>
        <a href="/job/${job.id}/"><button class="btn btn-success">Back</button> </a>
    </section>

</div>
</@layout.masterTemplate>