import { useSession } from "next-auth/react";
import { useRouter } from "next/router";

export default function User(props){
    const {data:session} = useSession()
    console.log(props.userJSON);
    console.log(session)
    if(props.userJSON){
        return <div className="text-white">
        <div className="flex">

            <div className="text-white">{props.userJSON.username}</div>
            <img src={props.userJSON.image}></img>
        </div>
        

        </div>
    }
    return <div className="text-white">
        <div>This User could not be found!</div>

    </div>
}
export async function getServerSideProps(context){
    const userData = await fetch("http://localhost:8080/user/returnUserByID", {method : "GET",
    headers : {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'id' : context.query.user
    }
    });
    const userJSON = await userData.json();
    const reviewData = await fetch("http://localhost:8080/user/returnReviewByUser", {method : "GET",
    headers : {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'userID' : context.query.user}})
    return {props : {userJSON}};
    
}