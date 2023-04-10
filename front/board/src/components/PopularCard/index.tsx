import { Box, Card, Chip, Typography } from '@mui/material';
import { useNavigate } from 'react-router-dom';

interface Props {
  title: string;
  popularList: string[];
}

export default function PopularCard({ title, popularList }: Props) {
  
  const navigator = useNavigate();

  return (
    <Card variant='outlined' sx={{ p: '24px 12px 26px 24px' }}>
        <Typography sx={{ fontSize: '24px', fontWeight: 500 }}>{title}</Typography>
        <Box sx={{ mt: '24px' }}>
          {popularList.length === 0 ? 
          (<Box sx={{ height: '344px', display: 'flex', justifyContent: 'center', alignItems: 'center' }}><Typography sx={{ fontSize: '24px', fontWeight: 500, color: 'rgba(0, 0, 0, 0.4)' }}>검색결과가 없습니다.</Typography></Box>) : 
          popularList.map((popular) => (
            <Chip sx={{ mr: '12px', mb: '12px', fontSize: '14px', fontWeight: 500 }} label={popular} variant="outlined" onClick={() => navigator(`/board/search/${popular}`)}/>
          ))}
        </Box>
    </Card>
  )
}
