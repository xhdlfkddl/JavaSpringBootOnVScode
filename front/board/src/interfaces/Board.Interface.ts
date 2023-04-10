interface Board {
    boardContent: string;
    // 변수명 뒤에 ?를 붙이는 이유는 해당 값이 필수가 아니란 것
    boardImgUrl?: string | null;
    boardNumber: number;
    boardTitle: string;
    boardWriteDatetime: string;
    commentCount: number;
    likeCount: number;
    viewCount: number;
    writerEmail: string;
    writerNickname: string;
    writerProfileUrl?: string | null;
}

export default Board;