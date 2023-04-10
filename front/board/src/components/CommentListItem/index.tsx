import { Avatar, Box, Divider, Typography } from '@mui/material';

import { Comment } from 'src/interfaces';

interface Props {
  item: Comment
}

export default function CommentListItem({ item }: Props) {

  const dateGap = Date.now() - Date.parse(item.writeDatetime);
  const before = Math.floor(dateGap / (1000 * 60));

  return (
    <Box>
        <Box sx={{ mb: '8px', display: 'flex', alignItems: 'center' }}>
            <Avatar sx={{ height: '32px', width: '32px', mr: '8px' }} src={item.writerProfileUrl ? item.writerProfileUrl : ''} />
            <Typography sx={{ fontSize: '16px', fontWeight: 500, color: 'rgba(0, 0, 0, 0.7)' }}>{item.writerNickname}</Typography>
            <Divider sx={{ mr: '8px', ml: '8px' }} orientation='vertical' variant='middle' flexItem />
            <Typography sx={{ fontSize: '16px', fontWeight: 400, color: 'rgba(0, 0, 0, 0.4)' }}>{before} 분 전</Typography>
        </Box>
        <Typography sx={{ fontSize: '18px', fontWeight: 500, lineHeight: '150%', color: 'rgba(0, 0, 0, 0.7)' }}>{item.commentContent}</Typography>
    </Box>
  )
}
