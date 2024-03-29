import './App.css';

import { useEffect } from 'react';
import { Routes, Route, useLocation } from 'react-router-dom';

import AuthenticationView from './views/AuthenticationView';
import NavigationBar from './views/NavigationBar';
import Main from './views/Main';
import Footer from './views/Footer';
import SearchView from './views/SearchView';
import MyPageView from './views/MyPageView';
import BoardWriteView from './views/Board/BoardWriteView';
import BoardUpdateView from './views/Board/BoardUpdateView';
import BoardDetailView from './views/Board/BoardDetailView';
import { useCookies } from 'react-cookie';
import { useUserStore } from './stores';
import axios, { AxiosResponse } from 'axios';
import ResponseDto from './apis/response';
import { authorizationHeader, GET_USER_URL } from './constants/api';
import { GetUserResponseDto } from './apis/response/user';

//# Router 설계 
//? 1. 'main' path 작성 : '/'
//? 2. 'auth' path 작성 : '/auth' (로그인 화면 / 회원가입 화면)
//? 3. 'myPage' path 작성 : '/myPage'
//? 4. 'boardSearch' path 작성 : '/board/search/:content'
//? 5. 'boardDetail' path 작성 : '/board/detail/:boardNumber'
//? 6. 'boardWrite' path 작성 : '/board/write'
//? 7. 'boardUpdate' path 작성 : '/board/update/:boardNumber'

function App() {

  const path = useLocation();
  const { setUser } = useUserStore();
  const [ cookies ] = useCookies();

  const getUser = (accessToken: string) => {
    // 토큰값으로 user 정보 받아오기
    axios.get(GET_USER_URL, authorizationHeader(accessToken))
      .then((response) => getUserResponseHandler(response))
      .catch((error) => getUserErrorHandler(error));
  }

  const getUserResponseHandler = (response: AxiosResponse<any, any>) => {
    const { result, message, data } = response.data as ResponseDto<any>;

    if(!result || !data) {
      return;
    }
    const user = data as GetUserResponseDto;
    setUser(user);
  }

  const getUserErrorHandler = (error: any) => {
    console.log(error.message);
  } 

  useEffect(() => {
    const accessToken = cookies.accessToken;
    if (accessToken) getUser(accessToken);
  }, [path]);

  return (
    <>
      <NavigationBar />
      <Routes>
        <Route path='/' element={(<Main />)} />
        <Route path='/auth' element={(<AuthenticationView />)} />
        <Route path='/myPage' element={(<MyPageView />)} />
        <Route path='/board'>
          <Route path='write' element={(<BoardWriteView />)} />
          <Route path='search/:content' element={(<SearchView />)} />
          <Route path='detail/:boardNumber' element={(<BoardDetailView />)} />
          <Route path='update/:boardNumber' element={(<BoardUpdateView />)} />
        </Route>
      </Routes>
      { path.pathname !== '/auth' && (<Footer />) }
    </>
  );
}

export default App;
