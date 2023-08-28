import { useSession, signIn } from "next-auth/react";
import { useEffect, useState } from "react";
function ReviewBox(props){
    const [sendReview, updateSendReview] = useState(false);
    const [reviewData, updateReviewData] = useState("");
    const [rating, setRating] = useState("3.67");
    const {data: session} = useSession()
    useEffect(()=>{
        const updateDatabase = async ()=>{
            const createReview = await fetch("http://localhost:8080/review/createReview", {method:'POST',
        headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'id' : session.user.name,
            'mediaType' : props.type,
            'mediaID' : props.id,
            'rating' : rating,
            'mediaTitle' : props.title
        },
        body : JSON.stringify(reviewData)
    });
        window.location.reload(false);
        }
        if(sendReview){
            updateDatabase();
        }
    },[sendReview]);
    
    if(props.doRender){
        return <div className="text-white">
            <textarea onChange={(e)=>{
                updateReviewData(e.target.value);
            }} className="bg-gray-600 border-2"></textarea>
            <button onClick={()=>{
                updateSendReview(true);
            }}>Submit!</button>

        </div>
    }
    return <></>
}
export default function IsLoggedInForReview(props){
    const [renderReviewBox, swapRenderReviewBox] = useState(false);
    const {data : session} = useSession();
    if(props.hasWritten){
        return<>
        <div className="text-white">This</div>
        </>
    }
    if(session){
        return <div>
            <div className="flex">
                <button onClick={()=>{swapRenderReviewBox(true)}}>
                    <div className="text-white">Write a review as: {session['user']['name']}</div>
                </button>
                <div className="px-4"><img src={session['user']['image']} className="border-2 border-gray-700 rounded" width={40}></img></div>
                
            </div>
            <br></br>
            <ReviewBox doRender={renderReviewBox} session={session} id={props.id} type={props.type} title={props.title}/>
        </div>
    }
    return <div>
        <div className="text-white flex ">
            <div >Please </div>
            <button className="px-1" onClick={()=> signIn()}> Log In</button>
            <div>to write a review!</div>
        </div>

    </div>
}