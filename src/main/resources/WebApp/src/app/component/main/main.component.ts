import { Component, OnInit } from '@angular/core';
import {PostDto} from '../../dto/PostDto';
import {PostService} from '../../service/post/post.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit {
  currentPage: number;

  /*posts: PostDto[];*/
  posts: PostDto[][]; /*first dimention for the page,and second dimention for the Post*/

  constructor(private postService: PostService) { }

  ngOnInit() {
    /*
    this.postService.getAllPosts().subscribe(
      posts => {
        this.posts = posts;
      }
    );
    */
    this.currentPage = 0;

    this.posts = [
      // Page 1
      [
        {
          id: 1,
          title: 'Post 1',
          body: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec lobortis turpis at ipsum hendrerit, vel porttitor velit ultrices.',
          date: '01.08.2020'
        },
        {
          id: 2,
          title: 'Post 2',
          body: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec lobortis turpis at ipsum hendrerit, vel porttitor velit ultrices.',
          date: '01.08.2020'
        },
        {
          id: 3,
          title: 'Post 3',
          body: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec lobortis turpis at ipsum hendrerit, vel porttitor velit ultrices.',
          date: '01.08.2020'
        },
        {
          id: 4,
          title: 'Post 4',
          body: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec lobortis turpis at ipsum hendrerit, vel porttitor velit ultrices.',
          date: '01.08.2020'
        }
      ],
      // Page 2
      [
        {
          id: 5,
          title: 'Post 5',
          body: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec lobortis turpis at ipsum hendrerit, vel porttitor velit ultrices.',
          date: '01.08.2020'
        },
        {
          id: 6,
          title: 'Post 6',
          body: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec lobortis turpis at ipsum hendrerit, vel porttitor velit ultrices.',
          date: '01.08.2020'
        },
        {
          id: 7,
          title: 'Post 7',
          body: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec lobortis turpis at ipsum hendrerit, vel porttitor velit ultrices.',
          date: '01.08.2020'
        },
        {
          id: 8,
          title: 'Post 8',
          body: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec lobortis turpis at ipsum hendrerit, vel porttitor velit ultrices.',
          date: '01.08.2020'
        }
      ],
      // Page 3
      [
        {
          id: 9,
          title: 'Post 9',
          body: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec lobortis turpis at ipsum hendrerit, vel porttitor velit ultrices.',
          date: '01.08.2020'
        },
        {
          id: 10,
          title: 'Post 10',
          body: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec lobortis turpis at ipsum hendrerit, vel porttitor velit ultrices.',
          date: '01.08.2020'
        },
        {
          id: 11,
          title: 'Post 11',
          body: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec lobortis turpis at ipsum hendrerit, vel porttitor velit ultrices.',
          date: '01.08.2020'
        },
        {
          id: 12,
          title: 'Post 12',
          body: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec lobortis turpis at ipsum hendrerit, vel porttitor velit ultrices.',
          date: '01.08.2020'
        }
      ]
    ];

  }

  updatePage(newPage){
    this.currentPage = newPage;
  }

}
