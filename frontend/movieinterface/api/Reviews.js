var urlBase = "http://localhost:8080"
export async function getReviews(id, mediatype){
    const reviewData = await fetch((urlBase+ "/media/returnSpecificMediaReview"),
    {method:"GET",
    headers:{
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'id' : id,
        'mediaType' : mediatype
    }})
    const reviews = await reviewData.json();
    return reviews;
}
export async function checkIfUserWroteReviewForPage(authorid, mediaid, mediatype){
    const check = await fetch(urlBase + "/review/checkIfReviewExistsByUser", {method : "GET",
        headers:{
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'authorid' : authorid,
        'mediatype' : mediatype,
        'mediaID' : mediaid
    }});
    const ret = await check.json();
    return ret;
}