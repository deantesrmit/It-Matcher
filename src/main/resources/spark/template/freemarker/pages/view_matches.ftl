<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Login">
<#include "../fragment/banner.html">
<div class="container">
    <h4 id="login">View Your Matches Below</h4>
    <br/>
    <div class="row" id="heading">
        <div class="col-sm-3">Job Name</div>
        <div class="col-sm-4">Job Description</div>
        <div class="col-sm-1">Budget</div>
        <div class="col-sm-2">Due Date</div>
        <div class="col-sm-1">Accept</div>
        <div class="col-sm-1">Decline</div>
    </div>
    <div class="matches">
        <#if jobOffers?has_content>
            <div class="row listings">
                <#list jobOffers as jobOffers>
                    <div class="col-sm-3">${jobOffers.title!}</div>
                    <div class="col-sm-4">${jobOffers.description!}</div>
                    <div class="col-sm-1">${jobOffers.budget!}</div>
                    <div class="col-sm-2">${jobOffers.dueDate!}</div>
                    <div class="col-sm-1">
                        <form class="acceptdecline" action="/viewMatches/" method="POST">
                            <input type="hidden" name="answer" value="1" />
                            <input type="hidden" name="jobID" value="${jobOffers.id!}" />
                            <input type="hidden" name="freelancerID" value="${freelancerID}" />
                            <input type="submit"  value="Accept" />
                        </form>
                    </div>
                    <div class="col-sm-1">
                        <form class="acceptdecline" action="/viewMatches/" method="POST">
                            <input type="hidden" name="answer" value="2" />
                            <input type="hidden" name="jobID" value="${jobOffers.id!}" />
                            <input type="hidden" name="freelancerID" value="${freelancerID}" />
                            <input type="submit" value="Decline" />
                        </form>
                    </div>
                    <br/><br/>
                </#list>
            </div>
        <#else> <br/><br/><p> You have no current Job Offers </p>
        </#if>

    </div>
</div>
</@layout.masterTemplate>