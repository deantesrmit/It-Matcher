<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Login">
<#include "../fragment/banner.html">
    <div class="container">
    <h4 id="login">View Your Matches Below</h4>
    <br/>
    <div class="matches">
        <div class="row" id="heading">
            <div class="col-sm-2">Job Name</div>
            <div class="col-sm-3">Job Description</div>
            <div class="col-sm-1">Budget</div>
            <div class="col-sm-2">Due Date</div>
            <div class="col-sm-2">Accept</div>
            <div class="col-sm-2">Decline</div>
        </div>
        <div class="row listings">
        <#list jobOffers as jobOffers>
            <div class="col-sm-2">${jobOffers.title!}</div>
            <div class="col-sm-3">${jobOffers.description!}</div>
            <div class="col-sm-1">${jobOffers.budget!}</div>
            <div class="col-sm-2">${jobOffers.dueDate!}</div>
            <div class="col-sm-2">
            <form class="form-login" action="/viewMatches/" method="POST">
                <input type="hidden" name="answer" value="1" />
                <input type="hidden" name="jobID" value="${jobOffers.id!}" />
                <input type="hidden" name="freelancerID" value="${freelancerID}" />
                <input type="submit" value="Accept Job" />
            </form>
            </div>
            <div class="col-sm-2">
            <form class="form-login" action="/viewMatches/" method="POST">
                <input type="hidden" name="answer" value="2" />
                <input type="hidden" name="jobID" value="${jobOffers.id!}" />
                <input type="hidden" name="freelancerID" value="${freelancerID}" />
                <input type="submit" value="Decline Job" />
            </form>
            </div>
        </#list>
        </div>
    </div>
</@layout.masterTemplate>