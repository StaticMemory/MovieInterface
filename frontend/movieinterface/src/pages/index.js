import Banner from "@/components/Banner"
import GenreTab from "@/components/GenreTab"
import MediaPreview from "@/components/MediaPreviewer"
import SearchBar from "@/components/SearchBar"
export default function Home() {
  return (
    <>
      <Banner/>
      <SearchBar/>
      <br></br>
      <div className="flex relative">
        <div>
          <div className="w-PreviewCardWidth text-center text-offgray text-2xl  p-1">Three "What Was He Cooking?" Moments</div>
          <MediaPreview/>
          <MediaPreview/>
          <MediaPreview/>
        </div>
        <div className="absolute right-0 p-16">
          <GenreTab></GenreTab>
        </div>
      </div>
      
    </>
  )
}
