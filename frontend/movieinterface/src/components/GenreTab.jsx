const { default: Link } = require("next/link")

const GenreList = ['Action', 'Comedy', 'Horror', 'Romance']


export default function GenreTab(){
    return <>
    <div className="justify-center flex">
        <div className="border-2 border-white w-64 text-white text-center justify-center ">Top Movie And TV Show Genres
            {GenreList.map((genre, index) => {
                return <div className=" text-LinkColour underline p-1"><Link id={index} href={`/genre/${genre}`}>{genre}</Link></div>
            })}
        </div>
    </div>
    </>
 }