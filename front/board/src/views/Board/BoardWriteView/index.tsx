import { KeyboardEvent, ChangeEvent, useEffect, useRef, useState } from 'react'
import { useNavigate } from 'react-router-dom';
import { useCookies } from 'react-cookie';

import axios, { AxiosResponse } from 'axios';

import { Box, Divider, Fab, IconButton, Input } from '@mui/material';
import ImageOutlinedIcon from '@mui/icons-material/ImageOutlined';
import CreateIcon from '@mui/icons-material/Create';
import { PostBoardDto } from 'src/apis/request/board';
import ResponseDto from 'src/apis/response';
import { PostBoardResponseDto } from 'src/apis/response/board';
import { authorizationHeader, FILE_UPLOAD_URL, multipartHeader, POST_BOARD_URL } from 'src/constants/api';

export default function BoardWriteView() {
  
  //           Hook           //
  const navigator = useNavigate();

  //? useRef = dom(document)
  //? html element를 담기 위한 state
  const imageRef = useRef<HTMLInputElement | null>(null);

  const [cookies] = useCookies();
  const [boardTitle, setBoardTitle] = useState<string>('');
  const [boardContent, setBoardContent] = useState<string>('');
  const [boardImgUrl, setBoardImgUrl] = useState<string>('');

  const accessToken = cookies.accessToken;


  //           Event Handler           //
  const onBoardContentChangeHandler = (event: ChangeEvent<HTMLTextAreaElement | HTMLInputElement>) => {
    const value = event.target.value;
    console.log(value);
    setBoardContent(value);
  }

  const onBoardContentKeyPressHandler = (event: KeyboardEvent<HTMLTextAreaElement | HTMLInputElement>) => {
    if (event.key != 'Enter') return;
    setBoardContent(boardContent + '\n');
  }

  const onWriteHandler = () => {
    //? 제목 및 내용 검증 (값이 존재하는지)
    if (!boardTitle.trim() || !boardContent.trim()) {
      alert('모든 내용을 입력해주세요.');
      return;
    }

    navigator('/myPage');

    postBoard();
  }

  const onImageUploadButtonHandler = () => {
    // 선택되어있지않다면
    if (!imageRef.current) return;
    imageRef.current.click();
  }

  const postBoard = () => {
    const data: PostBoardDto = { boardTitle, boardContent, boardImgUrl };
    axios.post(POST_BOARD_URL, data, authorizationHeader(accessToken))
    .then((response) => postBoardResponseHandler(response))
    .catch((error) => postBoardErrorHandler(error));
  }

  const onImageUploadChangeHandler = (event: ChangeEvent<HTMLInputElement>) => {
    // 선택한 파일이 존재하지않을 때
    if (!event.target.files) return;
    console.log(event.target.files[0]);
    // postman에서 form data로 보낸 작업을 만드는것!
    const data = new FormData();
    data.append('file', event.target.files[0]);

    axios.post(FILE_UPLOAD_URL, data, multipartHeader())
    .then((response) => imageUploadResponseHandler(response))
    .catch((error) => imageUploadErrorHandler(error));
  }


  //           Response Handler           //
  const postBoardResponseHandler = (response: AxiosResponse<any, any>) => {
    const { result, message, data } = response.data as ResponseDto<PostBoardResponseDto>
    if (!result || !data) {
      alert(message);
      return;
    }
  }

  const imageUploadResponseHandler = (response: AxiosResponse<any, any>) => {
    const imageUrl = response.data as string;
    // imageUrl이 빈값이거나 null이라면
    if (!imageUrl) return;
    setBoardImgUrl(imageUrl);
  }

  //           Error Handler           //
  const postBoardErrorHandler = (error: any) => {
    console.log(error.message);
  }

  const imageUploadErrorHandler = (error: any) => {
    console.log(error.message);
  }

  
  useEffect(() => {
    if (!accessToken) {
      alert('로그인이 필요한 작업입니당ㅋ');
      navigator('/auth');
    }
  },[]);

  return (
    <Box sx={{ p: '0px 198px', backgroundColor: 'rgba(0, 0, 0, 0.05)' }}>
      <Box sx={{ p: '100px 24px', backgroundColor: '#ffffff' }}>
        <Input fullWidth disableUnderline placeholder='제목을 입력하세요.' sx={{ fontSize: '32px', fontWeight: 500 }} onChange={(event) => setBoardTitle(event.target.value)} />
        <Divider sx={{ m: '40px 0px' }} />
        <Box sx={{ display: 'flex', alignItems: 'start' }}>

          <Box sx={{ width: '100%' }}>
            <Input fullWidth disableUnderline multiline minRows={5} placeholder='본문을 작성해주세요.' sx={{ fontSize: '18px', fontWeight: 500, lineHeight: '150%' }} onChange={(event) => onBoardContentChangeHandler(event)} onKeyDown={(event) => onBoardContentKeyPressHandler(event)} />
            <Box sx={{ width: '100%' }} component='img' src={boardImgUrl} />
          </Box>

          <IconButton onClick={() => onImageUploadButtonHandler()}>
            <ImageOutlinedIcon />
            <input ref={imageRef} hidden type='file' accept='image/*' onChange={(event) => onImageUploadChangeHandler(event)} />
          </IconButton>
        </Box>
      </Box>
      <Fab sx={{ position: 'fixed', zIndex: '999', bottom: '200px', right: '248px', backgroundColor: 'rgba(0, 0, 0, 0)' }} onClick={onWriteHandler}>
        <CreateIcon />
      </Fab>
    </Box>
  )
}
