export default function UserReview(props){
    // data: reviewData, type : review.reviewType, name: review.authorname mediaID, : review.mediaID
    // dateWritten: review.localDate, name : review.mediaName
    return <>
    <div className="border-2 border-gray-300"><div className="text-white">{props.mediaName}:{props.data}</div></div>
    
    
    
    </>
}