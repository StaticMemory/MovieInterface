import Link from "next/link";

export default function SearchResult(props){
    if(props.isMovie){
    return <>
    <div className="w-MovieSearchWidth">
        
            <div className="text-white flex w-MovieSearchWidth border-2">
                <div>
                    <div className="text-center italic font-bold underline w-64">
                        <Link href={"/Movie?&id="+props.id} className="w-MovieSearchWidth">{props.name}</Link><div className="h-full">
                            <img src={"https://image.tmdb.org/t/p/w500/"+props.imagePath} className="h-64 w-full"></img>
                        </div>
                    </div>
                </div>{props.info}
            </div>
    </div>
    </>}
    else if (props.isTV){
        return<>
        <div className="w-MovieSearchWidth">
        
            <div className="text-white flex w-MovieSearchWidth border-2">
                <div>
                    <div className="text-center italic font-bold underline w-64">
                        <Link href={"/Series?&id="+props.id} className="w-MovieSearchWidth">{props.name}</Link><div className="h-full">
                            <img src={"https://image.tmdb.org/t/p/w500/"+props.imagePath} className="h-64 w-full"></img>
                        </div>
                    </div>
                </div>{props.info}
            </div>
    </div>
    </>
    }
}  