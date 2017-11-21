<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Login">
<#include "../fragment/banner.html">
<div class="container">
    <h4 id="login">View Your Matches Below</h4>
    <br/>
    <div class="row" id="heading">
        <div class="col-sm-2">Job Name</div>
        <div class="col-sm-3">Job Description</div>
        <div class="col-sm-1">Budget</div>
        <div class="col-sm-2">Due Date</div>
        <div class="col-sm-2">Status</div>
        <div class="col-sm-1">Accept</div>
        <div class="col-sm-1">Decline</div>

    </div>
        <#if jobOffers?has_content>

                <#list jobOffers as jobOffer>
                <article class="search-result row">
                    <div class="col-sm-2">${jobOffer.title!}</div>
                    <div class="col-sm-3">${jobOffer.description!}</div>
                    <div class="col-sm-1">${jobOffer.budget!}</div>
                    <div class="col-sm-2">${jobOffer.dueDate!}</div>
                    <div class="col-sm-2">${jobOffer.status!}</div>
                    <#if jobOffer.status == "Pending">
                        <div class="col-sm-1">
                            <form class="acceptdecline" action="/viewMatches/" method="POST">
                                <input type="hidden" name="answer" value="1" />
                                <input type="hidden" name="jobID" value="${jobOffer.id!}" />
                                <input type="hidden" name="freelancerID" value="${freelancerID!}" />
                                <input type="submit"  value="Accept" />
                            </form>
                        </div>
                        <div class="col-sm-1">
                            <form class="acceptdecline" action="/viewMatches/" method="POST">
                                <input type="hidden" name="answer" value="2" />
                                <input type="hidden" name="jobID" value="${jobOffer.id!}" />
                                <input type="hidden" name="freelancerID" value="${freelancerID!}" />
                                <input type="submit" value="Decline" />
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