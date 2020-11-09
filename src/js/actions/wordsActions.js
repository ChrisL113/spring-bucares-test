import Axios from 'axios'
import { CHECK_WORD, DELETE_URL, GET_ALL_URLS } from './api'
import { ERASE_URL, FETCH_URLS } from './types'

export const checkWord = wordData => dispatch => {
  return Axios.post(CHECK_WORD, wordData)
    .then(res => {
      const response = {
        status: 200,
        apiRes: res.data.state,
      }
      return response
})
    .catch(err => {
      const response = {
        status: 500,
        msg: 'internal server error',
      }
      return response
    })
}

export const fetchUrls = () => dispatch => {
  return Axios.get(GET_ALL_URLS)
    .then(words => {
      dispatch({ type: FETCH_URLS, payload: words.data })
      if (words.status === 204) {
        const response = {
          status: 204,
          msg: 'there are no words at the moment !',
        }
        return response
      }
      const response = {
        status: 200,
        msg: '',
      }
      return response
    })
    .catch(err => {
      const response = {
        status: 500,
        msg: err.message,
      }
      return response
    })
}

export const deleteUrl = (url, another) => dispatch => {
  return Axios.delete(DELETE_URL, { headers: {}, data: { url: url } })
    .then(res => {
      dispatch({ type: ERASE_URL, payload: another })

      if (res.status === 204) {
        const response = {
          status: 204,
          msg: 'word not found',
        }
        return response
      }
      const response = {
        status: 200,
        msg: 'delete was succesful',
      }
      return response
    })
    .catch(err => {
      const response = {
        status: 500,
        msg: 'internal server error',
      }
      return response
    })
}
