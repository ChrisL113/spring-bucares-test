import moxios from 'moxios'
import configureMockStore from 'redux-mock-store'
import thunk from 'redux-thunk'
import { ERASE_URL } from '../../../js/actions/types'
import {
  checkWord,
  deleteUrl,
  fetchUrls,
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

  it(' has to return several urls', () => {
    const expectedResponse = [
      {
        url: 'www.google.co.ve',
      },
      {
        url: 'www.youtube.com',
      },
      {
        url: 'www.medium.com',
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

    return store.dispatch(fetchUrls()).then(() => {
      expect(store.getActions()[0].payload).toEqual(expectedResponse)
    })
  })

  it('has to delete a url', () => {
    const url = 'www.medium.com'
    const index = 0
    const store = mockStore()
    const expectedActions = [
      {
        type: ERASE_URL,
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
    return store.dispatch(deleteUrl(url, index)).then(() => {
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