package com.example.jetpacklearning_kotlin.movie_and_bill_app.model

data class MovieModel(val id:String,val title:String,val year:String,
    val genre:String,val director:String,val actor:String,
    val plot:String,val poster:String,val images:List<String>,
    val rating:String)

fun getMovies():List<MovieModel>{
    return listOf(
        MovieModel("1","lord of the ring1","2001","thrilling","devil",
                    "elijawood","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwaUHODKijkFERVgH9V2wkPk9OgVpKUMXdpWu9pGzYTiLGUQ62hEMWagZJhaUwnfF7MiQ&us ","poster", listOf(
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwaUHODKijkFERVgH9V2wkPk9OgVpKUMXdpWu9pGzYTiLGUQ62hEMWagZJhaUwnfF7MiQ&usqp=CAU",
                        "https://images0.persgroep.net/rcs/VT0B0hCGrWtIHOt9a4QWXJYw2UM/diocontent/15994655/_fitwidth/694/?appId=21791a8992982cd8da851550a453bd7f&quality=0.8",
                        "http://loyalkng.com/wp-content/uploads/2011/08/Gollum-Smeagol-smeagol-gollum-14076811-960-403.jpg",
                        "https://assets-prd.ignimgs.com/2022/05/16/lotrfellowship-1652740286087.jpg"
                    ),"8.9"),
        MovieModel("2","lord of the ring2","2001","thrilling","devil",
            "elijawood","unKnown","poster2", listOf(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwaUHODKijkFERVgH9V2wkPk9OgVpKUMXdpWu9pGzYTiLGUQ62hEMWagZJhaUwnfF7MiQ&usqp=CAU",
                "https://images0.persgroep.net/rcs/VT0B0hCGrWtIHOt9a4QWXJYw2UM/diocontent/15994655/_fitwidth/694/?appId=21791a8992982cd8da851550a453bd7f&quality=0.8",
                "http://loyalkng.com/wp-content/uploads/2011/08/Gollum-Smeagol-smeagol-gollum-14076811-960-403.jpg",
                "https://assets-prd.ignimgs.com/2022/05/16/lotrfellowship-1652740286087.jpg"
            ),"8.9"),
        MovieModel("3","lord of the ring3","2001","thrilling","devil",
            "elijawood","unKnown","poster3", listOf(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwaUHODKijkFERVgH9V2wkPk9OgVpKUMXdpWu9pGzYTiLGUQ62hEMWagZJhaUwnfF7MiQ&usqp=CAU",
                "https://images0.persgroep.net/rcs/VT0B0hCGrWtIHOt9a4QWXJYw2UM/diocontent/15994655/_fitwidth/694/?appId=21791a8992982cd8da851550a453bd7f&quality=0.8",
                "http://loyalkng.com/wp-content/uploads/2011/08/Gollum-Smeagol-smeagol-gollum-14076811-960-403.jpg",
                "https://assets-prd.ignimgs.com/2022/05/16/lotrfellowship-1652740286087.jpg"
            ),"8.9"),
        MovieModel("4","lord of the ring4","2001","thrilling","devil",
            "elijawood","unKnown","poster4", listOf(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwaUHODKijkFERVgH9V2wkPk9OgVpKUMXdpWu9pGzYTiLGUQ62hEMWagZJhaUwnfF7MiQ&usqp=CAU",
                "https://images0.persgroep.net/rcs/VT0B0hCGrWtIHOt9a4QWXJYw2UM/diocontent/15994655/_fitwidth/694/?appId=21791a8992982cd8da851550a453bd7f&quality=0.8",
                "http://loyalkng.com/wp-content/uploads/2011/08/Gollum-Smeagol-smeagol-gollum-14076811-960-403.jpg",
                "https://assets-prd.ignimgs.com/2022/05/16/lotrfellowship-1652740286087.jpg"
            ),"8.9"),
        MovieModel("5","lord of the ring5","2001","thrilling","devil",
            "elijawood","unKnown","poster5", listOf(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwaUHODKijkFERVgH9V2wkPk9OgVpKUMXdpWu9pGzYTiLGUQ62hEMWagZJhaUwnfF7MiQ&usqp=CAU",
                "https://images0.persgroep.net/rcs/VT0B0hCGrWtIHOt9a4QWXJYw2UM/diocontent/15994655/_fitwidth/694/?appId=21791a8992982cd8da851550a453bd7f&quality=0.8",
                "http://loyalkng.com/wp-content/uploads/2011/08/Gollum-Smeagol-smeagol-gollum-14076811-960-403.jpg",
                "https://assets-prd.ignimgs.com/2022/05/16/lotrfellowship-1652740286087.jpg"
            ),"8.9"),
        MovieModel("6","lord of the ring6","2001","thrilling","devil",
            "elijawood","unKnown","poster6", listOf(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwaUHODKijkFERVgH9V2wkPk9OgVpKUMXdpWu9pGzYTiLGUQ62hEMWagZJhaUwnfF7MiQ&usqp=CAU",
                "https://images0.persgroep.net/rcs/VT0B0hCGrWtIHOt9a4QWXJYw2UM/diocontent/15994655/_fitwidth/694/?appId=21791a8992982cd8da851550a453bd7f&quality=0.8",
                "http://loyalkng.com/wp-content/uploads/2011/08/Gollum-Smeagol-smeagol-gollum-14076811-960-403.jpg",
                "https://assets-prd.ignimgs.com/2022/05/16/lotrfellowship-1652740286087.jpg"
            ),"8.9"),
        MovieModel("7","lord of the ring7","2001","thrilling","devil",
            "elijawood","unKnown","poster7", listOf(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwaUHODKijkFERVgH9V2wkPk9OgVpKUMXdpWu9pGzYTiLGUQ62hEMWagZJhaUwnfF7MiQ&usqp=CAU",
                "https://images0.persgroep.net/rcs/VT0B0hCGrWtIHOt9a4QWXJYw2UM/diocontent/15994655/_fitwidth/694/?appId=21791a8992982cd8da851550a453bd7f&quality=0.8",
                "http://loyalkng.com/wp-content/uploads/2011/08/Gollum-Smeagol-smeagol-gollum-14076811-960-403.jpg",
                "https://assets-prd.ignimgs.com/2022/05/16/lotrfellowship-1652740286087.jpg"
            ),"8.9"),

    )
}