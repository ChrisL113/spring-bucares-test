import { ERASE_WORD, FETCH_WORDS } from '../actions/types'

const initialState = {
  items: [],
}

export default function (state = initialState, action) {
  switch (action.type) {
    case FETCH_WORDS:
      return {
        ...state,
        items: action.payload,
      }
    case ERASE_WORD:
      return {
        ...state,
        items: state.items.filter((item, index) => index !== action.payload),
      }

    default:
      return state
  }
}
