package org.comon.composevideoplayer.model

data class SeriesInfo (
    val id: Int = 0, // 작품 아이디
    val seasonId: Int = 0, // 시즌 아이디
    val title: String = "시리즈 제목", // 제목
    val description: String = "시리즈 설명", // 작품 설명
    val season: Int = 0, // 시즌
    val genres: List<String> = mutableListOf("액션", "드라마"), // 장르
    val uploadDate: String = "2024-11-28", // 등록일
    val rating: Int = 0, // 영상물 등급
    val photoUrl: String = "" // 포스터 이미지
)

data class VideoInfo (
    val id: Int = 0, // 한 회 아이디
    val seriesId: Int = 0, // 시리즈 아이디
    val title: String = "", // 한 회 제목
    val description: String = "", // 한 회 설명
    val uploadDate: String = "", // 한 회 등록일
    val rating: Int = 0, // 영상물 등급
    val photoUrl: String = "", // 한 회 이미지
    val runtime: Int = 0, // 한 회 상영 시간
)
