import request from '@/utils/request'

// 查询颜色信息列表
export function upload(fileInfo) {
  return request({
    url: 'fileInfo/fileInfo/upload',
    method: 'post',
    params: fileInfo
  })
}

// 查询颜色信息详细
export function download() {
  return request({
    url: 'fileInfo/fileInfo/download',
    method: 'post'
  })
}

