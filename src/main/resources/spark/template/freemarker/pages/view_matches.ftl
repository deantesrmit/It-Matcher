<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Login">
<#include "../fragment/banner.html">
<div class="container">
    <h4 id="login">View Your Matches Below</h4>
    <br/>
    <div class="row" id="heading">
        <div class="col-sm-2">Job Name</div>
        <div class="col-sm-4">Job Description</div>
        <div class="col-sm-1">Budget</div>
        <div class="col-sm-2">Due Date</div>
        <div class="col-sm-1">Status</div>
        <div class="col-sm-2"></div>


    </div>
        <#if jobOffers?has_content>

                <#list jobOffers as jobOffer>
                <article class="search-result row">
                    <div class="col-sm-2">${jobOffer.title!}</div>
                    <div class="col-sm-4">${jobOffer.description!}</div>
                    <div class="col-sm-1">${jobOffer.budget!}</div>
                    <div class="col-sm-2">${jobOffer.dueDate!}</div>
                    <div class="col-sm-1">${jobOffer.status!}</div>
                    <#if jobOffer.status == "Pending">
                        <div class="col-sm-2">
                            <form class="acceptdecline buttonMargin" action="/viewMatches/" method="POST">
                                <input type="hidden" name="answer" value="1" />
                                <input type="hidden" name="jobID" value="${jobOffer.id!}" />
                                <input type="hidden" name="freelancerID" value="${freelancerID!}" />
                                <button type="submit" value="Decline" class="btn btn-success btn-block">Accept</button>
                            </form>

                            <form class="acceptdecline buttonMargin" action="/viewMatches/" method="POST">
                                <input type="hidden" name="answer" value="2" />
                                <input type="hidden" name="jobID" value="${jobOffer.id!}" />
                                <input type="hidden" name="freelancerID" value="${freelancerID!}" />
                                <button type="submit" value="Decline" class="btn btn-danger btn-block">Decline</button>
                            </form>
                        </div>
                    </#if>

                    <br/><br/>
                </article>
                </#list>
        <#else> <br/><br/><p> You have no current Job Offers </p>
        </#if>

    </div>
</div>
</@layout.masterTemplate>