import Link from "next/link";

export default function SearchResult(){
    return <>
    <div className="w-MovieSearchWidth">
        <Link href="/Series?&title=dark " className="w-MovieSearchWidth">
            <div className="text-white flex w-MovieSearchWidth border-2">
                <div>
                    <div className="text-center italic font-bold underline w-64">Dark
                        <div className="h-full">
                            <img src="https://image.tmdb.org/t/p/w500/7yQyDCqSazrYTnmxdQLAZ8YDH87.jpg" className="h-64 w-full"></img>
                        </div>
                    </div>
                </div>
            </div>
        </Link>
    </div>
    </>
}  