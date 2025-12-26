let read_lines file =
  let contents = In_channel.with_open_bin file In_channel.input_all in
  String.split_on_char '\n' contents

let () = 
  let lines = read_lines "Day1_input.txt" in
  List.iter (fun line ->
    let n = String.length line in
    let sum = ref 0 in
    String.iteri (fun i c ->
      let next = line.[(i + 1) mod n] in
      if c = next then
        sum := !sum + (Char.code c - Char.code '0')
    ) line;
    Printf.printf "sum=%d" !sum
  ) lines

