package com.stone.radio.story

/**
 *   created by stone
 *   on 2020/7/14
 */
data class HttpResponse(
    val code: Int,
    val count: Int,
    val more: Boolean,
    val programs: List<Program>
)

data class Program(
    val bdAuditStatus: Int,
    val blurCoverUrl: String,
    val buyed: Boolean,
    val canReward: Boolean,
    val channels: List<String>,
    val commentCount: Int,
    val commentThreadId: String,
    val coverUrl: String,
    val createTime: Long,
    val description: String,
    val dj: Dj,
    val duration: Int,
    val id: Int,
    val isPublish: Boolean,
    val likedCount: Int,
    val listenerCount: Int,
    val mainSong: MainSong,
    val mainTrackId: Int,
    val name: String,
    val radio: Radio,
    val serialNum: Int,
    val shareCount: Int,
    val subscribed: Boolean
)

data class Dj(
    val avatarImgId: Long,
    val avatarImgIdStr: String,
    val avatarImgId_str: String,
    val avatarUrl: String,
    val backgroundImgId: Long,
    val backgroundImgIdStr: String,
    val backgroundUrl: String,
    val birthday: Long,
    val brand: String,
    val city: Int,
    val defaultAvatar: Boolean,
    val djStatus: Int,
    val followed: Boolean,
    val gender: Int,
    val mutual: Boolean,
    val nickname: String,
    val province: Int,
    val signature: String,
    val userId: Int,
    val vipType: Int
)

data class MainSong(
    val album: Album,
    val artists: List<Artist>,
    val bMusic: BMusic,
    val commentThreadId: String,
    val copyright: Int,
    val duration: Int,
    val id: Int,
    val lMusic: LMusic,
    val name: String,
    val popularity: Int,
    val score: Int,
    val starred: Boolean
)

data class Radio(
    val buyed: Boolean,
    val category: String,
    val categoryId: Int,
    val createTime: Long,
    val finished: Boolean,
    val id: Int,
    val lastProgramCreateTime: Long,
    val lastProgramId: Int,
    val name: String,
    val picId: Long,
    val picUrl: String,
    val programCount: Int,
    val subCount: Int
)

data class Album(
    val commentThreadId: String,
    val picUrl: String
)

data class Artist(
    val img1v1Url: String,
    val picUrl: String
)

data class BMusic(
    val bitrate: Int,
    val extension: String,
    val id: Long,
    val playTime: Int,
    val size: Int,
    val sr: Int
)

data class LMusic(
    val bitrate: Int,
    val extension: String,
    val id: Long,
    val playTime: Int,
    val size: Int,
    val sr: Int
)