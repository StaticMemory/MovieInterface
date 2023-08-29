import { useSession } from "next-auth/react";
import { useRouter } from "next/router";
import { getUserReviews, requestUserByID } from "../../../api/user";
import UserReview from "@/components/UserReview";
import Banner from "@/components/Banner";
import { useState } from "react";
export default function User(props){
    const router = useRouter();
    const {data:session} = useSession()
    const [searchOption, setSearchOption] = useState("");
    console.log(props.reviewData);
    if(!props.userData){
        return <div className="text-white">
            <Banner/>
        <div className="border-2 border-black justify-center flex bg-offgrayhighlight">
        <input className="text-black w-PreviewCardWidth border-2 border-offgrayhighlight" placeholder="  Search Movies, TV Shows, and Famous Actors!"
        onChange={(event) => {
            setSearchOption(event.target.value);
        }}
        onKeyDown={(event)=>{
            if(event.key === 'Enter'){
                router.push({pathname :"/Search",
                query : {
                    searchResult : searchOption
                }
    
            
                });
            }
        }}

        ></input>
    </div>
        <div>This User could not be found!</div>
        </div>
    }
    
    return <div className="text-white">
        <Banner/>
        <div className="border-2 border-black justify-center flex bg-offgrayhighlight">
        <input className="text-black w-PreviewCardWidth border-2 border-offgrayhighlight" placeholder="  Search Movies, TV Shows, and Famous Actors!"
        onChange={(event) => {
            setSearchOption(event.target.value);
        }}
        onKeyDown={(event)=>{
            if(event.key === 'Enter'){
                router.push({pathname :"/Search",
                query : {
                    searchResult : searchOption
                }
    
            
                });
            }
        }}

        ></input>
    </div>
    <div className="flex">

        <div className="text-white">{props.userData.username}</div>
        <img src={props.userData.image}></img>
    </div>
    <div className="text-white">Reviews!</div>
    {props.reviewData.map((review,id)=>{
        return <div key={id}><UserReview type={review.reviewType} name={review.authorName.replace(/['"]+/g, '')} mediaID={review.idOfMedia} dateWritten={review.localDate}
        val={review.reviewVal} data={review.reviewData.replace(/['"]+/g, '')} mediaName={review.nameOfMedia.replace(/['"]+/g, '')}/></div>
    })}

    </div>
}
export async function getServerSideProps(context){
    const userData = await requestUserByID(context.query.user);
    const reviewData = await getUserReviews(context.query.user)
    return {props : {userData, reviewData}};
    
}