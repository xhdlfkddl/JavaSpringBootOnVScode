import React, { useEffect, useState } from 'react'

import axios, { AxiosResponse } from 'axios';
import { Box, Card, Grid, Typography } from '@mui/material'

import ResponseDto from 'src/apis/response';
import { GetTop3ListResponseDto } from 'src/apis/response/board';
import PreviewCard from 'src/components/PreviewCard'
import { GET_TOP3_LIST_URL } from 'src/constants/api';

export default function MainHead() {

    //          Hook            //
    const [top3List, setTop3List] = useState<GetTop3ListResponseDto[]>([]);

    //          Event Handler            //
    const getTop3List = () => {
        axios.get(GET_TOP3_LIST_URL)
        .then((response) => getTop3ListResponseHandler(response))
        .catch((error) => getTop3ListErrorHandler(error));
    }

    //          Response Handler            //
    const getTop3ListResponseHandler = (response: AxiosResponse<any,any>) => {
        const { result, message, data } = response.data as ResponseDto<GetTop3ListResponseDto[]>;
        if(!result || data === null) return;
        setTop3List(data);
    }

    //          Error Handler            //
    const getTop3ListErrorHandler = (error: any) => {
        console.log(error.message);
    }

    useEffect(() => {
        getTop3List();
    }, []);

  return (
    <Box sx={{ pb: '40px', pl: '120px', pr: '120px' }}>
        {/* 점보트론 텍스트 */}
        <Box sx={{ pt: '80px', pb: '32px', textAlign: 'center' }}>
            <Typography sx={{ fontSize: '40px', fontWeight: 400 }}>Hoons Board에서</Typography>
            <Typography sx={{ fontSize: '40px', fontWeight: 400 }}>다양한 이야기를 나눠보세요.</Typography>
        </Box>
        {/* 주간 TOP 3 게시물 */}
        <Box>
            <Typography sx={{ fontSize: '24px', fontWeight: 400, p: '24px', textAlign: 'center' }}>주간 TOP 3 게시물</Typography>
            <Grid container spacing={3}>
                {top3List.map((item) => (
                    <Grid item sm={12} md={4}>
                        <PreviewCard previewItem={item} />
                    </Grid>
                ))}
            </Grid>
        </Box>
    </Box>
  )
}
