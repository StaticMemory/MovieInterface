export async function requestUser(userid){
    const userData = await fetch("http://localhost:8080/user/returnUserByName",{method : "GET",
    headers:{ "user" : userid
}});
    const userJsonData = await userData.json();
    return userJsonData
}
export async function requestUserByID(userid){
    const userData = await fetch("http://localhost:8080/user/returnUserByID", {method : "GET",
    headers : {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'id' : userid
    }});
    const ret = await userData.json();
    return ret;
}
export async function getUserReviews(userID){
    const reviewData = await fetch("http://localhost:8080/user/returnReviewByUser", {method : "GET",
    headers : {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'userID' : userID
    }});
    const ret = await reviewData.json()
    return ret;
}