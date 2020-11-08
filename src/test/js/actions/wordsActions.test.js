import moxios from 'moxios'
import configureMockStore from 'redux-mock-store'
import thunk from 'redux-thunk'
import { ERASE_WORD } from '../../../js/actions/types'
import {
  checkWord,
  deleteWord,
  fetchWords,
} from '../../../js/actions/wordsActions'

const middlewares = [thunk]
const mockStore = configureMockStore(middlewares)

describe('Word actions ', () => {
  beforeEach(() => {
    moxios.install()
  })
  afterEach(() => {
    moxios.uninstall()
  })

  it(' has to return several words', () => {
    const expectedResponse = [
      {
        url: 'www.google.co.ve',
        word: 'whatever',
      },
      {
        url: 'www.youtube.com',
        word: 'anotherstuff',
      },
      {
        url: 'www.medium.com',
        word: 'redux',
      },
    ]
    const store = mockStore({ words: [] })
    moxios.wait(() => {
      const request = moxios.requests.mostRecent()
      request.respondWith({
        status: 200,
        response: expectedResponse,
      })
    })

    return store.dispatch(fetchWords()).then(() => {
      expect(store.getActions()[0].payload).toEqual(expectedResponse)
    })
  })

  it('has to delete a word', () => {
    const url = 'www.medium.com'
    const index = 0
    const store = mockStore()
    const expectedActions = [
      {
        type: ERASE_WORD,
        payload: 0,
      },
    ]
    moxios.wait(() => {
      const request = moxios.requests.mostRecent()
      request.respondWith({
        status: 200,
        response: expectedActions,
      })
    })
    return store.dispatch(deleteWord(url, index)).then(() => {
      expect(store.getActions()).toEqual(expectedActions)
    })
  })
  it('has to create a word', () => {
    const data = {
      url: 'www.redux.js.org',
      word: 'thunk',
    }
    const store = mockStore()
    const expectedActions = []
    moxios.wait(() => {
      const request = moxios.requests.mostRecent()
      request.respondWith({
        status: 200,
        response: expectedActions,
      })
    })
    return store.dispatch(checkWord(data)).then(() => {
      expect(store.getActions()).toEqual(expectedActions)
    })
  })
})
