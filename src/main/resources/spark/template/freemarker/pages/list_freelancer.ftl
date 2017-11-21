<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Login">
<div class="container">

    <h1>Matched Freelancers for ${job.title}</h1>
    <br/>
    <ul>
      <li>Description:${job.description!}</li>
      <li>Due: ${job.dueDate!}</li>
      <li>Education: ${job.education!}</li>
      <li>Budget: ${job.budget!}</li>
      <li>Looking for skills:
      <#list job.skills! as skill>
          ${skill.value},
      </#list>
      </li>
    </ul>

    <br/>
    <br/>
    <h2 class="lead"><strong class="text-danger">${freelancers?size}</strong> IT professionals were found for the search for <strong
            class="text-danger">${job.title!}</strong></h2>
    <br/>
    <br/>

    <section class="col-xs-12 col-sm-6 col-md-12">
        <#list freelancers as scoredFreelancer>
            <#assign freeLancer = scoredFreelancer.freeLancer>
            <article class="search-result row">
                <div class="col-xs-11 col-md-1">
                    <span><h5>Score:${scoredFreelancer.score}</h5> </span>
                </div>
              <div class="col-xs-12 col-sm-12 col-md-3">
                <h5>Matched skills</h5>
                  <ul class="meta-search">
                      <li>
                          <span>
                              <#list freeLancer.matchedSkills as skill>
                              <strong>${skill.value},</strong>
                              </#list>
                          </span>
                      </li>

                  </ul>
              </div>
                <div class="col-xs-12 col-sm-12 col-md-5">
                    <h5>Skills</h5>
                    <ul class="meta-search">
                        <li>
                            <span>
                                <#list freeLancer.skills as skill>
                                ${skill.value},
                                </#list>
                            </span>
                        </li>

                    </ul>
                </div>
                <#assign offer = scoredFreelancer.offer!>
                <#assign offerStatus = offer.offerStatus!>
                <div class="col-xs-12 col-sm-12 col-md-3 excerpt">
                    <h5><a href="#" title="">${freeLancer.name}</a></h5>
                    <p>${freeLancer.bio}</p>
                    <form class="form-offer" action="/offer_job/" method="POST">
                        <input type="hidden" name="jobId" value="${job.id}">
                        <input type="hidden" name="freeLancerId" value="${freeLancer.id}">

                        <#if offerStatus + '' == '0'>
                            <input type="hidden" name="offerStatus" value="3">
                            <input type="submit" class="btn btn-primary btn-md btn-danger" value="Cancel Offer" />
                        <#else>
                            <input type="hidden" name="offerStatus" value="0">
                            <input type="submit" class="btn btn-primary btn-md" value="Offer Job" />
                        </#if>
                    </form>
                </div>
                <span class="clearfix borda"></span>
            </article>
        </#list>
        <a href=/profile/><button class="btn btn-success">Back</button> </a>
    </section>

</div>
</@layout.masterTemplate>