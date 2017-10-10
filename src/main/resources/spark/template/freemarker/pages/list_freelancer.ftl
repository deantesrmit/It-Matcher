<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Login">
<#--<#include "../fragment/banner.html">-->
<div class="container">

    <h1>Matched Freelancers</h1>
    <br/>
    <br/>
    <br/>
    <h2 class="lead"><strong class="text-danger">3</strong> IT proffesionals were found for the search for <strong class="text-danger">building a website</strong></h2>
    <br/>
    <br/>

    <section class="col-xs-12 col-sm-6 col-md-12">
        <article class="search-result row">
            <div class="col-xs-12 col-sm-12 col-md-3">
                <a href="#" title="no photo" class="thumbnail"><img src="../img/no-photo.jpg" alt="NO PHOTO" /></a>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-2">
                <ul class="meta-search">
                    <li> <span>Master of IT</span></li>
                    <li> <span>20 years IT Exprience</span></li>
                    <li> <span>html,css,php,javascript</span></li>
                </ul>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-7 excerpet">
                <h3><a href="#" title="">Melissa Thompson</a></h3>
                <p>15 years of web building exprience.</p>
                <button type="button" class="btn btn-success"> OFFER JOB</button>
            </div>
            <span class="clearfix borda"></span>
        </article>

        <article class="search-result row">
            <div class="col-xs-12 col-sm-12 col-md-3">
                <a href="#" title="no photo" class="thumbnail"><img src="../img/no-photo.jpg" alt="NO PHOTO" /></a>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-2">
                <ul class="meta-search">
                    <li> <span>BCompSc</span></li>
                    <li> <span>11 years IT Exprience</span></li>
                    <li> <span>java,php,photoshop</span></li>
                </ul>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-7 excerpet">
                <h3><a href="#" title="">Bede Hickey</a></h3>
                <p>best web builder with the lowest price.</p>
                <button type="button" class="btn btn-success"> OFFER JOB</button>
            </div>
            <span class="clearfix borda"></span>
        </article>

        <article class="search-result row">
            <div class="col-xs-12 col-sm-12 col-md-3">
                <a href="#" title="no photo" class="thumbnail"><img src="../img/no-photo.jpg" alt="NO PHOTO" /></a>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-2">
                <ul class="meta-search">
                    <li><span>BCompSc</span></li>
                    <li> <span>12 years IT Exprience</span></li>
                    <li> <span>C++,html,swift</span></li>
                </ul>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-7 excerpet">
                <h3><a href="#" title="">Stephen Collard</a></h3>
                <p>best web builder with the lowest price.</p>
                <button type="button" class="btn btn-success"> OFFER JOB</button>
            </div>
            <span class="clearfix borda"></span>
        </article>
    </section>

</div>
</@layout.masterTemplate>