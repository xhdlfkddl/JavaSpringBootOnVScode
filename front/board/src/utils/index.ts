//? 각종 일반 함수 관리
export const getPageCount = (list: any[], count: number) => 
    Math.floor((list.length - 1) / count) + 1;

export const getExpires = (expiredTime: number) => {
    //? 쿠키에 로그인 데이터 (Token) 보관 
    const now = new Date().getTime();
    const expires = new Date(now + expiredTime);

    return expires
}